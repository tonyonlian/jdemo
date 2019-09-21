package com.tunyl.tthread;

/**
 * 演示死锁的demo
 * @author create by Tunyl on 2019/9/18
 * @version 1.0
 */
public class DeadLockDemo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();
    private  static void startThreadA(){
        Thread athread = new Thread(){

            @Override
            public void run() {
                synchronized (lockA){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    synchronized (lockB){

                    }
                }
            }

        };
        athread.start();

    }

    private static void startThreadB(){
        Thread bthread = new Thread(){
            @Override
            public void run() {
               synchronized (lockB){
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (lockA){

                   }
               }
            }
        };
        bthread.start();
    }

    public static void main(String[] args) {
        startThreadA();
        startThreadB();
    }
}
