package com.tunyl.tthread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示AtomicInteger 的原子操作
 * @author create by Tunyl on 2019/9/19
 * @version 1.0
 */
public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger(0);
    static class Visitor extends Thread{

        @Override
        public void run() {
            for (int i=0;i<1000;i++) {
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num =1000;
        Thread[] threads = new Thread[num];
        for (int i=0;i<num; i++) {
            threads[i] = new Visitor();
            threads[i].start();
        }
        for (int i=0;i<num;i++) {
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
