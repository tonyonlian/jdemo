package com.tunyl.tthread;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 演示生产与消费者的代码
 * java提供了阻塞队列：
 * 接口BlockingQueue 和 BlockingDeque
 * 基于数组的实现类： ArrayBlockingQueue
 * 基于链表实现的类; LinkedBlockingQueue 和 LinkedBlockingDeque
 * 基于堆实现的类; PriorityBlockingQueue
 *
 * @author create by Tunyl on 2019/9/23
 * @version 1.0
 */
public class MyBlockingQueue<E> {
    private Queue<E> queque = null;
    private int limit;
    public MyBlockingQueue(int limit){
        this.limit = limit;
        queque = new ArrayDeque<>(limit);
    }
    public synchronized  void put(E e) throws InterruptedException {
        while(queque.size()==limit){
            wait();
        }
        queque.add(e);
        notifyAll();
    }
    public synchronized  E take() throws InterruptedException {
        while(queque.isEmpty()){
            wait();
        }
        E e = queque.poll();
        notifyAll();
        return e;
    }

}
