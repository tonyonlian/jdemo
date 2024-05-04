package com.tongyl.example.springcoretest.config;

import com.tongyl.example.springcoretest.model.Car;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
@Configuration
public class CustomBean {
    @Bean(initMethod = "myInit",destroyMethod = "myDestroy")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setColor("white");
        car.setMaxSpeed("500");
        return car;
    }
}
