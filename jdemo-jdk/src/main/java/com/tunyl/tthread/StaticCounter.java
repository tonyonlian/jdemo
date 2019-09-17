package com.tunyl.tthread;

/**
 * synchronizd修饰静态方法
 * @author Created by Tunyl on 2019/9/17.
 * @version 1.0
 */
public class StaticCounter {
    private static  int count =0;
    public static synchronized void incr(){
        count++;
    }
    public static synchronized int getCount(){
        return count;
    }
}
