package com.tunyl.tthread;

/**
 * synchronized 修饰代码块
 * @author Created by Tunyl on 2019/9/17.
 * @version 1.0
 */
public class BCounter {
    private int count;
    public void incr(){
        synchronized (this){
            count++;
        }
    }
    public int getCount(){
        synchronized (this){
            return count;
        }
    }
}
