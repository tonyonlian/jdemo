package com.tongyl.example.springcoretest.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author Created by Tunyl on 2019/9/15.
 * @version 1.0
 */
//1 管理bean的生命周期接口
public class Car implements BeanFactoryAware, BeanNameAware , InitializingBean , DisposableBean {
    private String color;
    private String brand;
    private String maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car()构造器。");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性。");
        this.brand = brand;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + "color='" + color + '\'' + ", brand='" + brand + '\'' + ", maxSpeed='" + maxSpeed + '\'' + '}';
    }
//2 BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()。");
        this.beanFactory = beanFactory;

    }
//3 BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.out.println("调用EeanNameAware.setBeanName()。");
        this.beanName = s;

    }
//4 InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()。");
    }
//5 DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()。");

    }
// 6 通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240 。");
        this.maxSpeed = "240";
    }
//  7 通过<bean>的destroy-method属性指定销毁方法
    public void myDestroy(){
        System.out.println("调用destroy-method所指的myDestroy()。");
    }
}
