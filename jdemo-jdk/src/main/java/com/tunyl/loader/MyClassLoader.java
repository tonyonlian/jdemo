package com.tunyl.loader;

import com.tunyl.iodemo.ReadFs;

/**
 * @author create by Tunyl on 2019/10/22
 * @version 1.0
 */
public class MyClassLoader extends ClassLoader{
    public static final String BASE_DIR = "D:\\IdeaProjects\\\\jdemo\\";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.","/");
        fileName = BASE_DIR + fileName +".class";
        byte[] bytes = ReadFs.toByteArray(fileName);
        return defineClass(name, bytes, 0, bytes.length);

    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader cl1 = new MyClassLoader();
        String className = "com.tunyl.iodemo.ReadF";
        Class<?> clazz = cl1.loadClass(className);
        MyClassLoader cl2 = new MyClassLoader();
        Class<?> clazz1 = cl2.loadClass(className);
        System.out.println(cl2.getParent());
        if(clazz !=clazz1){
            System.out.println("different classes");
        }

    }
}
