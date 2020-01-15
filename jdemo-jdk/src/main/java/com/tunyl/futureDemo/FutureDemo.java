package com.tunyl.futureDemo;


import java.util.concurrent.CompletableFuture;

/**
 * @author create by Tunyl on 2020/1/15
 * @version 1.0
 */
public class FutureDemo {
    public static void main(String[] args) {
        completedFutureExample();
        runAsyncExample();
        thenApplyExample();
        thenApplyAsyncExample();
    }

    static void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        if(cf.isDone()){
           String value =  cf.getNow(null);
            System.out.println(value);

        }
    }

    static void runAsyncExample() {
        CompletableFuture cf = CompletableFuture.runAsync(() ->{
          String threadName =   Thread.currentThread().getName();
          System.out.println("Thread name is " + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("任务执行中断");
            }
        });
        System.out.println(cf.isDone());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("任务执行中断");
        }
        System.out.println(cf.isDone());
    }

    static void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("say to  message")
                .thenApply(s -> {
                    boolean isDaemon = Thread.currentThread().isDaemon();
                    System.out.println("isDaemon：" + isDaemon);
                    return s.toUpperCase();
                });
        String vlaue =  cf.getNow(null);
        System.out.println(vlaue);
    }

    static void thenApplyAsyncExample() {
        CompletableFuture<String> cf =  CompletableFuture.completedFuture("message")
                .thenApplyAsync(s ->{
                    boolean isDaemon = Thread.currentThread().isDaemon();
                    return s.toUpperCase();
                });
        System.out.println(cf.getNow(null));
        String value = cf.join();
        System.out.println("value=" + value);
    }


}
