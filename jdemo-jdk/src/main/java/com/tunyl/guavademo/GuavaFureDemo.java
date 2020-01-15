package com.tunyl.guavademo;

import com.google.common.util.concurrent.*;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author create by Tunyl on 2020/1/6
 * @version 1.0
 */
public class GuavaFureDemo {
    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWaterJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            Thread.sleep(SLEEP_GAP);
            System.out.println("烧水了");
            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            Thread.sleep(SLEEP_GAP);
            System.out.println("清洗完了");
            return true;
        }
    }

    static class MainJob implements Runnable {
        boolean warterOk = false;
        boolean cupOk = true;
        int gap = SLEEP_GAP / 10;
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    System.out.println("读书中......");
                } catch (InterruptedException e) {
                    System.out.println(getCurThreadName() + "发生异常这被中断");
                }
                if (warterOk && cupOk) {
                    drinkTea(warterOk, cupOk);
                }
            }
        }
        public void drinkTea(Boolean wOk, Boolean cOk) {
            if (wOk && cOk) {
                System.out.println("泡茶喝，茶喝完");
                this.warterOk = false;
                this.gap = SLEEP_GAP * 100;
            } else if (!wOk) {
                System.out.println("烧水失败，没喝到茶");
            } else if (!cOk) {
                System.out.println("杯子洗不了，没有茶喝");
            }
        }
    }

    public static void main(String[] args) {
        MainJob mainJob = new MainJob();
        Thread mainTread = new Thread(mainJob);
        mainTread.start();

        Callable<Boolean> hotJob = new HotWaterJob();
        Callable<Boolean> washJob = new WashJob();
        //创建java 线程池
        ExecutorService jPool =
                Executors.newFixedThreadPool(10);

        //包装java线程池，构造guava 线程池
        ListeningExecutorService gPool =
                MoreExecutors.listeningDecorator(jPool);

        ListenableFuture<Boolean> hotFuture = gPool.submit(hotJob);
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    mainJob.warterOk = true;
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("烧水失败，没有茶喝了");
            }
        },gPool);
        ListenableFuture<Boolean> washFuture = gPool.submit(washJob);
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    mainJob.cupOk = true;
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("杯子洗不了，没有茶喝");
            }
        },gPool);
    }


}
