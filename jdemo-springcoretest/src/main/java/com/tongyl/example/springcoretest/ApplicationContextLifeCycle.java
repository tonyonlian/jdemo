package com.tongyl.example.springcoretest;

import com.tongyl.example.springcoretest.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示ApplicationContext的生命周期
 * @author create by Tunyl on 2019/10/28
 * @version 1.0
 */
public class ApplicationContextLifeCycle {
    public static void main(String[] args) {
        //根据application.xml 初始化ApplicationContext实例
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        //获取Car的javabean
        Car car = ctx.getBean("car",Car.class);
        //打印Car实例
        System.out.println(car);


    }
}
