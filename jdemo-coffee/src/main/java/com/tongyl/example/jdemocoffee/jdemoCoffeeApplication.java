package com.tongyl.example.jdemocoffee;

import com.tongyl.example.jdemocoffee.model.Coffee;
import com.tongyl.example.jdemocoffee.model.CoffeeOrder;
import com.tongyl.example.jdemocoffee.model.OrderState;
import com.tongyl.example.jdemocoffee.repository.CoffeeRepository;
import com.tongyl.example.jdemocoffee.service.CoffeeOrderService;
import com.tongyl.example.jdemocoffee.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Created by Tunyl on 2019/9/10.
 * @version 1.0
 */
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class jdemoCoffeeApplication implements ApplicationRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private JedisPoolConfig jedisPoolConfig;


    public static void main(String[] args) {
        SpringApplication.run(jdemoCoffeeApplication.class,args);
    }
    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }
    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host,@Value("${redis.port}") int port, @Value("${redis.password}") String password ){
        return new JedisPool(jedisPoolConfig(), host,port,10,password);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        cacheTest();
        testJedis();

    }



    private void curdtest() {
        log.info("All Coffee: {}",coffeeService.findOneCoffee("latte"));
        Optional<Coffee> latte = coffeeService.findOneCoffee("latte");
        if(latte.isPresent()){
            CoffeeOrder order = orderService.createOredr("Li Lei",latte.get());
            log.info("Update INIT to PAID: {}",orderService.updateState(order, OrderState.PAID));
            log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
        }
    }

    private void cacheTest(){
        log.info("Count: {}", coffeeService.findAllCoffee());
        for (int i = 0; i <10 ; i++) {
            log.info("Reading from cache");
            List<Coffee> list =  coffeeService.findAllCoffee();
            log.info("Cache Count: {}",list.size());
        }
        coffeeService.updateAllCoffee();
        log.info("Update Cache");
        for (int i = 0; i <10 ; i++) {
            log.info("Reading from update cache");
           List<Coffee> list2 = coffeeService.findAllCoffee();
            log.info("Update Cache Count: {}", list2.size());
        }

        coffeeService.reloadCoffee();
        log.info("Reading after refresh");
        coffeeService.findAllCoffee().forEach(c ->log.info("Coffee: {}",c.getName()));
    }


     private void testJedis(){
         log.info(jedisPoolConfig.toString());

         try(Jedis jedis = jedisPool.getResource()) {
             coffeeService.findAllCoffee().forEach(c -> {
                 jedis.hset("springbucks-menu",c.getName(),Long.toString(c.getPrice().getAmountMinorLong()));
             });

             Map<String, String> menu = jedis.hgetAll("springbucks-menu");
             log.info("Menu: {}", menu);

             String price = jedis.hget("springbucks-menu", "espresso");
             log.info("espresso: {}", Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
         }


     }

//    @Bean
//    public CacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("coffee")));
//        return cacheManager;
//    }





}
