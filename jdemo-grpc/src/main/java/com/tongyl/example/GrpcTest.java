package com.tongyl.example;

import java.io.IOException;

/**
 * @author create by Tunyl on 2019/12/28
 * @version 1.0
 */
public class GrpcTest {
    public static void main(String[] args) throws IOException {

        HelloWorldClient client = new HelloWorldClient("localhost",9000);
        String reply = client.sayHello("LiLEue");
        System.out.println(reply);


    }

}
