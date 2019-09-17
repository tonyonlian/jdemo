package com.tunyl.tthread;

/**
 * @author Created by Tunyl on 2019/9/14.
 * @version 1.0
 */
public class ThreadTest implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main() Thread name:" + Thread.currentThread().getName());
        Thread t1 = new Thread(new ThreadTest());
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("over");

    }

    @Override
    public void run() {

        System.out.println("run() Thread name  :" + Thread.currentThread().getName() + " id:" + Thread.currentThread().getId());
    }
}
