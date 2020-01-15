package com.tongyl.example.nettydemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;



/**
 * @author create by Tunyl on 2020/1/8
 * @version 1.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        StringBuilder builder = new StringBuilder();
        while (in.isReadable()) {
            builder.append((char) in.readByte());
          //  System.out.println((char) in.readByte());
        }
        System.out.println(builder.toString());
        ((ByteBuf)msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
