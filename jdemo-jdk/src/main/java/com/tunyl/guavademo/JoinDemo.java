package com.tunyl.guavademo;

/**
 * @author create by Tunyl on 2020/1/4
 * @version 1.0
 */
public class JoinDemo {
    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }
    static class HotWarterThread extends Thread{
         public HotWarterThread(){
             super("** 烧水-Tread");
         }

        @Override
        public void run() {
            try {
                Thread.sleep(SLEEP_GAP);
                System.out.println(Thread.currentThread().getName());
                System.out.println("水烧开了");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("发生异常被中断");
            }
        }
    }

    static class WashThread extends Thread {

        public WashThread() {
            super("$$ 清洗-Thread");
        }

        @Override
        public void run() {
            try {
                Thread.sleep(SLEEP_GAP);
                System.out.println(Thread.currentThread().getName());
                System.out.println("清洗完毕");
            } catch (InterruptedException e) {
                System.out.println("发生异常中断");
            }
        }
    }

    public static void main(String[] args) {
        Thread hTread = new HotWarterThread();
        Thread wTread = new WashThread();
        hTread.start();;
        wTread.start();
        try {
            wTread.join();
            hTread.join();
            Thread.currentThread().setName("主线程");
            System.out.println("泡茶喝");
        } catch (InterruptedException e) {
            System.out.println("发生异常中断");
        }
        System.out.println(getCurThreadName()+" 运行结束 ");
    }
}
