package com.trip.atguigu.reactor.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

public class EchoServer {
    public static final int port=8088;
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
               /* .option(ChannelOption.SO_BACKLOG,1024)
                .option(ChannelOption.SO_REUSEADDR)*/
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                             .addLast(new LineBasedFrameDecoder(10000))
                                .addLast(new EchoServerHandler());
                    }
                });
        ChannelFuture sync = bootstrap.bind().sync();
        sync.channel().closeFuture().sync();
        group.shutdownGracefully().sync();
    }
}
