package com.tongyl.example.springcoretest;

import com.tongyl.example.springcoretest.config.CustomBean;
import com.tongyl.example.springcoretest.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示基于注解类的配置，注入bean
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
public class AnnContextTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CustomBean.class);
//        Car car = ctx.getBean("buildCar",Car.class);
        Car car = ctx.getBean(Car.class);
        System.out.println(car.toString());
    }
}
