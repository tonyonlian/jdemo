package com.tunyl.tthread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author create by Tunyl on 2019/9/20
 * @version 1.0
 */
public class LockSupoortTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("exit");
            }
        };

        t.start();
        Thread.sleep(1000);
        System.out.println("chirend  thread  is park");
        LockSupport.unpark(t);


    }
}
