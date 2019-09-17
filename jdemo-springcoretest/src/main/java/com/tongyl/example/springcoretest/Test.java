package com.tongyl.example.springcoretest;

import com.tongyl.example.springcoretest.model.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author Created by Tunyl on 2019/9/15.
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource res = resolver.getResource("classpath:bean.xml");
//
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(res);
//        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ((ClassPathXmlApplicationContext) context).addApplicationListener(c ->{
            System.out.println(c.getSource().toString());

        });
        ApplicationEvent event = new ApplicationContextEvent(context) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        };
        context.publishEvent(event);
        Car car = context.getBean("car", Car.class);
        System.out.println(car.toString());

    }
}
