package com.tongyl.example;

import io.grpc.stub.StreamObserver;

/**
 * @author create by Tunyl on 2019/12/28
 * @version 1.0
 */
public class HelloWorldRpcService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("调用实现");
        String name =  request.getName();
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + name + "!")
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
