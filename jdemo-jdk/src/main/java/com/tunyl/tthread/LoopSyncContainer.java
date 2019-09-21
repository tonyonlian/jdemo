package com.tunyl.tthread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  演示容器迭代时修改会有异常，同步容器也解决不了此问题
 * @author create by Tunyl on 2019/9/21
 * @version 1.0
 */
public class LoopSyncContainer {
    private static void startModifyThread(final List<String> list) {
        Thread modifyThread = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    list.add("item" + i);
                    try {
                        Thread.sleep((long) (Math.random() * 10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        modifyThread.start();
    }

    private static void startIteratorThread(final List<String> list) {
        Thread iteratorThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (String str : list) {

                    }
                }
            }
        };
        iteratorThread.start();

    }

    public static void main(String[] args) {
        final List<String> list = Collections.synchronizedList(new ArrayList<>());

        startIteratorThread(list);
        startModifyThread(list);
    }
}
/**
 * 加锁可以解决此问题
 * private static void startIteratorThread(final List<String> list){
 *             Thread iteratorThread = new Thread(){
 *                 @Override
 *                 public void run() {
 *                     while(true){
 *                         synchronized (list) {
 *                             for (String str : list) {
 *
 *                             }
 *                         }
 *                     }
 *                 }
 *             };
 *             iteratorThread.start();
 *
 *         }
 */
