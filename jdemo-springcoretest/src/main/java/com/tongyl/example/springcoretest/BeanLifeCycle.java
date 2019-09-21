package com.tongyl.example.springcoretest;

import com.tongyl.example.springcoretest.model.Car;
import com.tongyl.example.springcoretest.model.MyBeanPostProcessor;
import com.tongyl.example.springcoretest.model.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
/**
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
// 1装载配置并启动容器
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:bean.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
// 2 向容器中注册MyBeanPostProcessor后处理器
        factory.addBeanPostProcessor(new MyBeanPostProcessor());
// 3 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        factory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
// 4 第一次从容器中获取car 将触发容器实例化Bean ，这将引发bean的生命周期方法高调用
        Car car1 = (Car) factory.getBean("car");
        System.out.println(car1.toString());
        car1.setColor("红色");
// 5第二次从容器中获取car 直接从缓存池中获取
        Car car2 = (Car) factory.getBean("car");
// 6查看car1和car2是否指向同一个引用
        System.out.println("car1==car2："+ (car1==car2));
// 7关闭容器
        factory.destroySingletons();

    }
}
