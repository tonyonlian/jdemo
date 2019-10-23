package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/29
 * @version 1.0
 */
public class MyLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int workerNum = 100;
        MyLatch myLatch = new MyLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for(int i =0;i<workerNum;i++ ) {
            workers[i] = new Worker(myLatch);
            workers[i].start();
        }

        myLatch.await();
        System.out.println("collect worker results");
    }
}
