package com.trip.atguigu.reactor.adv;

import com.trip.atguigu.reactor.adv.server.ServerInit;
import com.trip.atguigu.reactor.adv.vo.NettyConstant;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;

public class NettyServer {

    public void bind() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(NettyRuntime.availableProcessors());
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ServerInit());

        bootstrap.bind(NettyConstant.SERVER_PORT).sync();
        NettyConstant.LOG.info("Netty Server start", "ip:{},port:{}", NettyConstant.SERVER_IP, NettyConstant.SERVER_PORT);
    }

    public static void main(String[] args) throws InterruptedException {
        NettyServer server =new NettyServer();
        server.bind();
    }
}
