package com.trip.atguigu.reactor.adv.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class ServerInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 固定长度的报文 前两位是报文的长度
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
        ch.pipeline().addLast(new LengthFieldPrepender(2));

        ch.pipeline().addLast(new KryoDecoder());
        ch.pipeline().addLast(new KryoEecoder());
    }
}
