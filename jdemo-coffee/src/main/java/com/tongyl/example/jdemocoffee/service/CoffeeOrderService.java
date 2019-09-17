package com.tongyl.example.jdemocoffee.service;

import com.tongyl.example.jdemocoffee.model.Coffee;
import com.tongyl.example.jdemocoffee.model.CoffeeOrder;
import com.tongyl.example.jdemocoffee.model.OrderState;
import com.tongyl.example.jdemocoffee.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Created by Tunyl on 2019/9/10.
 * @version 1.0
 */
@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOredr(String customer, Coffee ...coffees){
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);

       return saved;
    }

    public boolean updateState(CoffeeOrder order,OrderState state){
        if(state.compareTo(order.getState())<=0){
            log.warn("Wrong State order: {}, {}",state,order.getItems());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}",order);
        return true;
    }

}
