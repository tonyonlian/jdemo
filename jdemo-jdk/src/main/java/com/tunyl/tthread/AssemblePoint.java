package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/30
 * @version 1.0
 */
public class AssemblePoint {
    private int n;
    public AssemblePoint(int n){
        this.n = n;
    }
    public synchronized void await() throws InterruptedException {
        if(n>0){
            n --;
            if(n==0){
                notifyAll();
            }else{
                while(n != 0){
                    wait();
                }
            }
        }
    }
}
