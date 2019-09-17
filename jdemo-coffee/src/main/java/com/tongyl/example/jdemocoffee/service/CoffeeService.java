package com.tongyl.example.jdemocoffee.service;

import com.tongyl.example.jdemocoffee.model.Coffee;
import com.tongyl.example.jdemocoffee.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @author Created by Tunyl on 2019/9/10.
 * @version 1.0
 */
@Slf4j
@Service
//公共配置  可以在类上注释 注释本类的 缓存相关公共配置
@CacheConfig(cacheNames = CoffeeService.CACHE_KEY)
public class CoffeeService {
    public static final String CACHE_KEY = "coffee";
    @Autowired
    private CoffeeRepository coffeeRepository;

    //获取信息  第二次访问会取缓存
    @Cacheable
    public List<Coffee> findAllCoffee(){
        return coffeeRepository.findAll();
    }

    //更新缓存
    @CachePut
    public List<Coffee> updateAllCoffee(){
         coffeeRepository.deleteById(4L);
         return coffeeRepository.findAll();
    }

    //清除缓存
    @CacheEvict
    public void reloadCoffee(){

    }

    public Optional<Coffee> findOneCoffee(String name){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name",exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(Example.of(Coffee.builder().name(name).build()));
        log.info("Coffee Found: {}",coffee);
        return coffee;

    }


}
