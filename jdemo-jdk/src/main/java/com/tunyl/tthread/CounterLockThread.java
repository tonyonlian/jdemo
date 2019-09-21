package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/18
 * @version 1.0
 */
public class CounterLockThread extends Thread {

    LockCounter lockCounter;

    public CounterLockThread(LockCounter counter){
        this.lockCounter = counter;

    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            lockCounter.incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockCounter counter = new LockCounter();
        int num  =100;
        Thread[] threads = new Thread[num];
        long t1 = System.currentTimeMillis();
        for(int i=0;i<num;i++){
            threads[i] = new CounterLockThread(counter);
            threads[i].start();
        }

        for(int i=0;i<num ;i++){
            threads[i].join();

        }
        long t2 = System.currentTimeMillis();

        System.out.println("COUNT: "+ counter.getCount()+" useTime:"+(t2-t1));

    }
}
