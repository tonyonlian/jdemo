package com.tunyl.refect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * @author Created by Tunyl on 2019/9/5.
 * @version 1.0
 */
public class ReflectConstructorDemo implements Serializable {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = null;
        System.out.println("Class 方法演示");
        //获取Class的对象引用
        clazz = Class.forName("com.tunyl.refect.User");
        //第一种方法，实例化默认构造器，User必须无参构造函数，否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(23);
        user.setName("Devid");
        System.out.println("User:" + user.toString());
        printBouLine();
        //获取带String参数的public构造函数
        Constructor cs1 = clazz.getConstructor(String.class);
        User user1 = (User) cs1.newInstance("Jim");
        user1.setAge(22);
        System.out.println("User1:" + user1.toString());
        printBouLine();
        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2 = clazz.getDeclaredConstructor(int.class, String.class);
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        User user2 = (User) cs2.newInstance(25,"Bob");
        System.out.println("User:" + user2.toString());
        printBouLine();
        //获取所有构造包含private
        Constructor<?> [] cons = clazz.getDeclaredConstructors();
        for(Constructor<?> cs :cons){
            Class<?>[] clazzs = cs.getParameterTypes();
            System.out.println("构造函数：" + cs.toString());
            System.out.println("构造函数的参数类型：[");
            for(Class<?> claz :clazzs){
                System.out.println(claz.getName());
            }

            System.out.println("]");
        }

        printBouLine();
        System.out.println("Constructor 方法活演示");
        Constructor cs3 = clazz.getDeclaredConstructor(int.class,String.class);
        printBouLine();
        Class uclass = cs3.getDeclaringClass();
        System.out.println("构造方法的类"+ uclass.getName());

        Type[] tps = cs3.getGenericParameterTypes();
        for(Type tp :tps){
            System.out.println("参数名称（type)："+tp);
        }

        Class<?>[] clazzs = cs3.getParameterTypes();
        for(Class cz : clazzs){
            System.out.println("参数名程(Class)："+cz.getName());
        }
        System.out.println("getoGenericString():"+cs3.toString());

        printBouLine();
        cs3.setAccessible(true);
        User u3 = (User) cs3.newInstance(2,"ddd");
        System.out.println(u3.toString());







    }

    private static void printBouLine(){
        System.out.println("============");
    }


}
