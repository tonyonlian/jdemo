package com.tunyl.tthread;

/**
 * 运动员类
 *
 * @author create by Tunyl on 2019/9/24
 * @version 1.0
 */
public class Racer extends Thread {
    FireFlag fireFlag;

    public Racer(FireFlag fireFlag) {
        this.fireFlag = fireFlag;
    }

    @Override
    public void run() {
        try {
            this.fireFlag.waitForfire();
            System.out.println("start run " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
