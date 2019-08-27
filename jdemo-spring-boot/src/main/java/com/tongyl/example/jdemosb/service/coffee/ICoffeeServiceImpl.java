package com.tongyl.example.jdemosb.service.coffee;

import com.tongyl.example.jdemosb.dao.CoffeeMapper;
import com.tongyl.example.jdemosb.entity.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by Tunyl on 2019/8/27.
 * @version 1.0
 */
@Slf4j
@Service
public class ICoffeeServiceImpl implements ICoffeeService {
    @Autowired
    private CoffeeMapper coffeeMapper;

    @Override
    public void save() {
//        Coffee c = Coffee.builder()
//                .name("espresso")
//                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
//                .build();
//        int count = coffeeMapper.save(c);
//        log.info("Save {} Coffee:{}",count,c);
//        c = Coffee.builder()
//                .name("latte")
//                .price(Money.of(CurrencyUnit.of("CNY"),25.0))
//                .build();
//        count = coffeeMapper.save(c);
//        log.info("Save {} Coffee: {}",count,c);
        Coffee c  = coffeeMapper.findById(2L);
        log.info("Find Coffee :{}",c);
    }
}
