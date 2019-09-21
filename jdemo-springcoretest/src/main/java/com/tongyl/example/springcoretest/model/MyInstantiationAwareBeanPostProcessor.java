package com.tongyl.example.springcoretest.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
// 1 接口方法：在实例化Bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        1-1 仅对容器中的car Bean处理
        if("car".equals(beanName)){
            System.out.println("调用：InstantiationAwateBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }
//2 接口方法：在实例化Bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        2-1仅对容器中car bean处理
        if("car".equals(beanName)) {
            System.out.println("调用: InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation ");
        }
        return true;
    }
//3 接口方法：在设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//        3-1 仅对容器中car bean处理，还可以通过pds入参进行过滤，仅对car的特定属性进行处理
        if("car".equals(beanName)){
            System.out.println("调用： InstantiationAwareBeanPostProcessor.postProcessPropertyValues ");
        }
        return pvs;
    }
}
