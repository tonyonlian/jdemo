package com.tunyl.loader;

import com.sun.javaws.IconUtil;

/**
 * @author create by Tunyl on 2019/10/22
 * @version 1.0
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        while(cl !=null ){
            System.out.println(cl.getClass().getName());
            cl = cl.getParent();
        }
        System.out.println(String.class.getClassLoader());
        ClassLoader c2 =  ClassLoader.getSystemClassLoader();
        Class<?> cls = c2.loadClass("java.util.ArrayList");
        ClassLoader actualLoader = cls.getClassLoader();
        System.out.println(actualLoader);
    }
}
