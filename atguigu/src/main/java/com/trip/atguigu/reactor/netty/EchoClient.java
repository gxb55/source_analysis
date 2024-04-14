package com.trip.atguigu.reactor.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

public class EchoClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventExecutors =new NioEventLoopGroup();
        Bootstrap bootstrap =new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .remoteAddress("127.0.0.1",EchoServer.port)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoClientHandler());
                    }
                });

        ChannelFuture sync = bootstrap.connect().sync();
        sync.channel().closeFuture().sync();
        eventExecutors.shutdownGracefully().sync();
        System.in.read();
    }
}
