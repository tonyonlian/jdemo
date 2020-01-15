package com.tunyl.niodemo;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author create by Tunyl on 2020/1/3
 * @version 1.0
 */
public class NioSendClient {
    private Charset charset = Charset.forName("UTF-8");

//    public void sendFile() {
//        try{
//            String srcPath = "d:/niotest/robot.jpg";
//            String destFile = "robot.rec.jpg";
//            File file = new File(srcPath);
//            if (!file.exists()) {
//                System.out.println("文件不存在");
//                return;
//            }
//            FileChannel fileChannel = new FileInputStream(file).getChannel();
//            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1",9001));
//            socketChannel.configureBlocking(false);
//            System.out.println("Client 成功连接服务端");
//            while(!socketChannel.finishConnect()){
//
//            }
//
//            ByteBuffer fileNameByteBuffer = charset.encode(destFile);
//            socketChannel.write(fileNameByteBuffer);
//
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            System.out.println("文件长度：" + file.length());
//            buffer.putLong(file.length());
//
//            buffer.flip();
//            socketChannel.write(buffer);
//            buffer.clear();
//
//            System.out.println("开始传输文件");
//            int length = 0;
//            long progress = 0L;
//            while ((length = fileChannel.read(buffer)) > 0) {
//                buffer.flip();
//                while(buffer.hasRemaining()) {
//                    socketChannel.write(buffer);
//                }
//                buffer.clear();
//                progress += length;
//                System.out.println("| " + (100 * progress / file.length()) + "% |");
//
//            }
//            if(length == -1){
//                fileChannel.close();
//                socketChannel.close();
//            }
//            System.out.println("文件传输成功");
//
//
//
//
//
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        NioSendClient client = new NioSendClient();
        client.sendFile();
    }

    public void sendFile() {
        try {

            String srcPath = "d:/niotest/robot.jpg";
            System.out.println("srcPath=" + srcPath);

            String destFile ="robot.rec.jpg";
            System.out.println("destFile=" + destFile);

            File file = new File(srcPath);
            if (!file.exists()) {
                System.out.println("文件不存在");
                return;
            }
            FileChannel fileChannel = new FileInputStream(file).getChannel();

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(
                    new InetSocketAddress("127.0.0.1"
                            , 9001));
          //  socketChannel.configureBlocking(false);
            System.out.println("Cliect 成功连接服务端");

            while (!socketChannel.finishConnect()) {
                //不断的自旋、等待，或者做一些其他的事情
            }

            //发送文件名称
            ByteBuffer fileNameByteBuffer = charset.encode(destFile);
            socketChannel.write(fileNameByteBuffer);

            //发送文件长度
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.putLong(file.length());

            buffer.flip();
            while(buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();

            //发送文件内容
            System.out.println("开始传输文件");
            int length = 0;
            long progress = 0;
            while ((length = fileChannel.read(buffer)) > 0) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                }
                buffer.clear();
                progress += length;
                System.out.println("| " + (100 * progress / file.length()) + "% |");
            }
            if (length == -1) {
                fileChannel.close();
                socketChannel.shutdownOutput();
                socketChannel.close();
            }
            System.out.println("======== 文件传输成功 ========");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
