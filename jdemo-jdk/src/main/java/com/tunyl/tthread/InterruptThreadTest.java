package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/10/8
 * @version 1.0
 */
public class InterruptThreadTest {
    public static void main(String[] args) {

        Thread t =  new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(isInterrupted());
                }
            }
        };
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("main Thread Exception ....");
        }
        t.interrupt();
    }
}
