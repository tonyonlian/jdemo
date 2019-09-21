package com.tunyl.tthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示显示锁（ReentrantLock）
 */
public class LockCounter {
    private final Lock lock = new ReentrantLock();
    private volatile int count;
    public void incr(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public int getCount(){
        return count;
    }
}
