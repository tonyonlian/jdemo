package com.tunyl.tthread;

/**
 *
 * 演示生产者代码
 * @author create by Tunyl on 2019/9/23
 * @version 1.0
 */
public class Producer extends Thread {
    MyBlockingQueue<String> queue;
    public Producer(MyBlockingQueue<String> queque){
        this.queue=queque;
    }

    @Override
    public void run() {
       int num = 0;

        try {
            while(true){
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("Produce task "+task);
                num++;
                Thread.sleep((long) (Math.random() *100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

