package com.tongyl.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author create by Tunyl on 2019/12/28
 * @version 1.0
 */
public class GrpcServer {

    private final int port;
    private Server server;

    public GrpcServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        /* The port on which the server should run */

        server = ServerBuilder.forPort(port)
                .addService(new HelloWorldRpcService())
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    GrpcServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        final GrpcServer server = new GrpcServer(9000);
        server.start();
        //server.blockUntilShutdown();
        server.stop();
    }

//    private Server server;
//    public GrpcServer(int port){
//        server = ServerBuilder.forPort(9000)
//                .addService(new HelloWorldRpcService())
//                .build();
//
//    }
//
//    public void start() throws IOException {
//        server.start();
//    }
//
//    public void shutdown(){
//        server.shutdown();
//    }
//
//    public static void main(String[] args) throws IOException {
//        GrpcServer server = new GrpcServer(9000);
//        server.start();
//    }
}
