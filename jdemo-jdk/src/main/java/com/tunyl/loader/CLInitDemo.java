package com.tunyl.loader;

/**
 * @author create by Tunyl on 2019/10/22
 * @version 1.0
 */
public class CLInitDemo {
    public static class hello{
        static{
            System.out.println("hello");
        }

        public static void main(String[] args) throws ClassNotFoundException {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            String name = CLInitDemo.class.getName() + "$hello";
            Class<?> cls = Class.forName(name);

        }
    }
}
