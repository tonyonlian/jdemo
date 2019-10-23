package com.tunyl.tthread;

/**
 * 演示同时开始的协作类
 * @author create by Tunyl on 2019/9/24
 * @version 1.0
 */
public class FireFlag {
    private volatile boolean fired = false;
    public synchronized void waitForfire() throws InterruptedException {
        while(!fired){
            wait();
        }
    }
    public synchronized void fire(){
        this.fired = true;
        notifyAll();
    }
}
