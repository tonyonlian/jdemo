package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/10/8
 * @version 1.0
 */
public class InterruptSynchronizedDemo {
    private static Object lock = new Object();
    private static class A extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                while(!Thread.currentThread().isInterrupted()){

                }
            }
            System.out.println("exit");
        }
    }
    public static void test() throws InterruptedException {
        synchronized (lock){
            A a = new  A();
            a.start();
            Thread.sleep(1000);
            a.interrupt();
            a.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
