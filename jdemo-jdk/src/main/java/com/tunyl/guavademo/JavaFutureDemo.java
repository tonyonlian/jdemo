package com.tunyl.guavademo;


import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author create by Tunyl on 2020/1/4
 * @version 1.0
 */
public class JavaFutureDemo {
    public static final int SlEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }
    static class HotWarterJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                Thread.sleep(SlEEP_GAP);
                System.out.println("水开了");
            }catch(InterruptedException e){
                System.out.println("烧水工作发现异常被中断");
                return false;
            }
            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                Thread.sleep(SlEEP_GAP);
                System.out.println("洗完了");
            } catch (InterruptedException e) {
                System.out.println("清洗工作发生异常中断");
                return false;
            }
            return true;
        }
    }

    public static void drinkTea(boolean waterOk, boolean cupOk) {
        if(waterOk && cupOk){
            System.out.println("泡茶喝");
        } else if (!waterOk) {
            System.out.println("烧水失败");
        } else if (!cupOk) {
            System.out.println("清洗杯子失败");
        }
    }

    public static void main(String[] args) {
        Callable<Boolean> hJob = new HotWarterJob();
        FutureTask<Boolean> hTask = new FutureTask<>(hJob);
        Thread thread = new Thread(hTask, "** 烧水-Thread");
        Callable<Boolean> wJob = new WashJob();
        FutureTask<Boolean> wTask = new FutureTask<>(wJob);
        Thread wThread = new Thread(wTask, "$$ 清洗-Tread");
        thread.start();
        wThread.start();
        Thread.currentThread().setName("主线程");
        try {
            boolean waterOk = hTask.get();
            boolean cupOk = wTask.get();
        } catch (InterruptedException e) {
            System.out.println("中断异常");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(getCurThreadName() + " 运行结束 ");
    }
}

