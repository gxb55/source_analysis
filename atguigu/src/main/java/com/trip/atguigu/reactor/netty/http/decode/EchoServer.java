package com.trip.atguigu.reactor.netty.http.decode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.util.concurrent.DefaultThreadFactory;

public class EchoServer {
    public static void main(String[] args) throws InterruptedException {
        new EchoServer().startEchoServer(8088);
    }

    private void startEchoServer(int port) throws InterruptedException {
        /**
         * 1.创建NioEventLoop
         * 2.绑定 select
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));
        NioEventLoopGroup workGroup = new NioEventLoopGroup(5, new DefaultThreadFactory("work"));
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(1000));
                        ch.pipeline().addLast(new MyEchoServerHandler());
                    }
                });
        /**
         * 1.反射创建NioServerSocketChannel，创建的过程中设置pipeline和unsafe DefaultChannelPipeline，里面自动创建head和tail
         * 2.创建，初始化，注册
         * 3.fireChannelRegistered，fireChannelActive
         */
        ChannelFuture sync = bootstrap.bind(port).sync();
        sync.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
