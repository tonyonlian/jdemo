package com.tongyl.example.jdemosb.service.coffee;

import com.tongyl.example.jdemosb.TestAbstract;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Created by Tunyl on 2019/8/27.
 * @version 1.0
 */
public class ICoffeeServiceImplTest extends TestAbstract {
    @Autowired
    private ICoffeeService coffeeService;
    @Test
    public void save() {
        coffeeService.save();
    }
}