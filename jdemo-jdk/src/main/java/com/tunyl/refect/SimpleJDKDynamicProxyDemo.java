package com.tunyl.refect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author create by Tunyl on 2019/10/18
 * @version 1.0
 */
public class SimpleJDKDynamicProxyDemo {
    static interface  IService{
        public void sayHello();
    }
    static class RealService implements IService{
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }

    }
    static class SimpleInvocationHandler implements InvocationHandler {
        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(proxy.getClass().getName());
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leavine " + method.getName());
            return result;
        }
    }
    public void say(){
        System.out.println("the say method");

    }


    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),new Class<?>[]{IService.class},new SimpleInvocationHandler(realService));
        proxyService.sayHello();
    }
}
