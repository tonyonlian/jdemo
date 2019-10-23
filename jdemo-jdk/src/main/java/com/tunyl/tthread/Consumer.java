package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/23
 * @version 1.0
 */
public class Consumer extends Thread {
    MyBlockingQueue<String> queue;
    public Consumer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while(true){
                String task = queue.take();
                System.out.println("handle task"+task);
                Thread.sleep((long) (Math.random() *100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
