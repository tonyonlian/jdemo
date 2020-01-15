package com.tongyl.example.springcoretest.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author create by Tunyl on 2019/10/28
 * @version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {

        BeanDefinition bd = bf.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand", "QQ奇瑞");
        System.out.println("调用： BeanFactoryPostProcessor.postProcessBeanFactory()方法");
    }
}
