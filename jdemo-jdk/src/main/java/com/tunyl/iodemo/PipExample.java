package com.tunyl.iodemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author create by Tunyl on 2019/10/17
 * @version 1.0
 */
public class PipExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream();
        input.connect(output);
        Thread tread1 = new Thread(){
            @Override
            public void run() {
               try{
                   output.write("Hello world".getBytes());
               }catch(IOException e){

               }finally{
                   try {
                       output.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try{
                    int data =0;
                    StringBuilder br = new StringBuilder();
                    while((data=input.read())!=-1){
                      //  System.out.println((char)data);
                        br.append((char)data);
                    }

                    System.out.println(br.toString());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        };
        tread1.start();
        thread2.start();
        try {
            tread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
