package com.tunyl.tthread;

/**
 * 协作对象
 *
 * @author create by Tunyl on 2019/9/29
 * @version 1.0
 */
public class MyLatch {
    private int count;

    public MyLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;

        if (count <= 0) {
            notifyAll();
        }
    }
}
