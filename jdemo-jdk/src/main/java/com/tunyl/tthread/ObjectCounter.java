package com.tunyl.tthread;

/**
 * 任一对象作为锁
 * @author Created by Tunyl on 2019/9/17.
 * @version 1.0
 */
public class ObjectCounter {
    private int count = 0;
    private Object lock = new Object();
    public void incr(){
        synchronized (lock) {
            count++;
        }
    }
    public int getCount(){
        synchronized (lock){
            return count;
        }
    }
}
