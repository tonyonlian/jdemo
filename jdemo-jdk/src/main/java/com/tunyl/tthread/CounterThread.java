package com.tunyl.tthread;

/**
 * @author Created by Tunyl on 2019/9/16.
 * @version 1.0
 */
public class CounterThread extends Thread {
    Counter counter;
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++) {
            counter.insr();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        long t1 = System.currentTimeMillis();
        for (int i=0;i<num;i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();

        }
        for (int i =0;i<num;i++) {
            threads[i].join();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Count:"+ counter.getCount()+"  useTime:"+ (t2-t1));

    }
}
