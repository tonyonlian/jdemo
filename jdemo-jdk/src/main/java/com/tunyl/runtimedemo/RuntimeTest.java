package com.tunyl.runtimedemo;

/**
 * @author create by Tunyl on 2019/12/30
 * @version 1.0
 */
public class RuntimeTest {

    public static void main(String[] args) {
        //Runtime 可以获取当前JVM最大内存，空闲内存，内存，系统
        Runtime runtime = Runtime.getRuntime();
        System.out.println("JVM最大内存：" + runtime.maxMemory());
        System.out.println("JVM空闲内存：" + runtime.freeMemory());
        System.out.println("JVM的内存：" +runtime.totalMemory());
        System.out.println("JVM的核数：" + runtime.availableProcessors());

        runtime.addShutdownHook(new Thread(){
            //优雅的关闭程序
            @Override
            public void run() {
                System.out.println("JVM shutdown ");
            }
        });
    }
}
