package com.tongyl.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author create by Tunyl on 2019/12/28
 * @version 1.0
 */
public class HelloWorldClient {

    private final GreeterGrpc.GreeterBlockingStub blockingStub;


    public HelloWorldClient(String host,int port) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(managedChannel);


    }

    public String sayHello(String name){

        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        HelloReply reply = blockingStub.sayHello(request);
        return reply.getMessage();

    }
}
