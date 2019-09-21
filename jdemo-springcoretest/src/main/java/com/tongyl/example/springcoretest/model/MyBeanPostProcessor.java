package com.tongyl.example.springcoretest.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car = (Car) bean;
            if(car.getColor() == null){
                System.out.println("调用 BeanPostProcessor.postProcessBeforeInitialization(),color 为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car = (Car) bean;
            if(Integer.parseInt(car.getMaxSpeed())>200){
                System.out.println("调用 BeanPostProcessor.postProcessAfterInitialization(),将maxSpeed调整为200 。");
                car.setMaxSpeed("200");
            }
        }
        return bean;
    }
}
