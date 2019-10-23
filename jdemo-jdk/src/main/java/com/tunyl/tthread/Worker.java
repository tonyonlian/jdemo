package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/29
 * @version 1.0
 */
public class Worker extends Thread {
    MyLatch myLatch;

    public Worker(MyLatch myLatch) {
        this.myLatch = myLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 100));
            this.myLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
