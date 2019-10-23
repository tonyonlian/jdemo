package com.tunyl.tthread;

/**
 * 演示集合点
 * java有专们的同步工具类：CyclicBarrier
 * @author create by Tunyl on 2019/9/30
 * @version 1.0
 */
public class AssemblePointDemo {
    static class Tourist extends Thread{
        AssemblePoint ap;
        public Tourist(AssemblePoint ap){
            this.ap = ap;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 10000));
                ap.await();
                System.out.println("arrived");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            int num = 10;
            Tourist[] tourists = new Tourist[num];
            AssemblePoint ap = new AssemblePoint(num);
            for(int i=0;i<num;i++){
                tourists[i] = new Tourist(ap);
                tourists[i].start();
            }
        }
    }
}
