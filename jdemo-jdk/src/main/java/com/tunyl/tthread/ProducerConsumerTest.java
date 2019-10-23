package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/23
 * @version 1.0
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
