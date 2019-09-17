package com.tunyl.tthread;

/**
 * synchronized 修饰实例方法
 * @author Created by Tunyl on 2019/9/16.
 * @version 1.0
 */
public class Counter {

    private int count;
    public synchronized void insr(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }

}
