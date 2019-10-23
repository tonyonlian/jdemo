package com.tunyl;

/**
 * @author create by Tunyl on 2019/10/16
 * @version 1.0
 */
public class ServiceA {
    @SimpleInject
    ServiceB b;
   public void callB(){
       System.out.println(b);
       b.action();
   }
    public static void main(String[] args) {
       for(int i=0;i<10;i++) {
           ServiceA a = SimpleContainer.getInstance(ServiceA.class);
           a.callB();
       }
    }
}
