package com.tongyl.example.jdemosb.service.task;

import com.tongyl.example.jdemosb.TestAbstract;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * @author create by Tunyl on 2020/1/13
 * @version 1.0
 */
public class TaskTest extends TestAbstract {
    @Autowired
    Task task;
    @Test
    public void doTask() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while(true){
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(40);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务总耗时：" + (end - start) + "毫秒");
    }
    @Test
    public void doTaskOne() {
    }

    @Test
    public void doTaskTwo() {
    }

    @Test
    public void doTaskThree() {
    }
}