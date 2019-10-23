package com.tunyl.datastructrue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author create by Tunyl on 2019/10/10
 * @version 1.0
 */
public class MyQueue {
    private Integer[] data ;
    private int pHead;
    private int pTail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyQueue(int k) {
        this.size = k;
        this.pTail = -1;
        this.pHead = -1;
        this.data = new Integer[k];

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(pHead==-1){
            pHead = ++pHead % size;
        }
        pTail = ++pTail % size;

        data[pTail]=value;
        return true;


    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        pHead = ++pHead % size;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[pHead];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[pTail];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(pHead==-1 && pTail ==-1){
            return true;
        }
        int temp = (pHead+1)%size;
        if(temp > pTail && (pHead<pTail)){
            pHead = -1;
            pTail = -1;
            return true;
        }

        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        int temp = (pTail +1) %size;
        if(temp==pHead){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(6);
        System.out.println(myQueue.enQueue(6));
        System.out.println(myQueue.Rear());
        System.out.println(myQueue.Rear());

//        System.out.println(myQueue.enQueue(2));
//        System.out.println(myQueue.enQueue(3));
//        System.out.println(myQueue.enQueue(4));
//        System.out.println(myQueue.Rear());
//        System.out.println(myQueue.isFull());
//        System.out.println(myQueue.deQueue());
//        System.out.println(myQueue.enQueue(4));
//        System.out.println( myQueue.Rear());
    }

}
