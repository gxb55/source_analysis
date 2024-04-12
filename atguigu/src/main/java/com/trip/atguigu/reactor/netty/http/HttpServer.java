package com.trip.atguigu.reactor.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.net.InetSocketAddress;

/**
 * @author xbguo
 * @date 2024/4/12 10:23
 */
public class HttpServer {
    public static void main(String[] args) throws Exception {
        new HttpServer().start(8088);
    }
    public void start(int port) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();

        b.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("codec",new HttpServerCodec()) // HTTP 编解码
                                .addLast("compressor",new HttpContentCompressor()) // HttpContext 压缩
                                .addLast("aggregator",new HttpObjectAggregator(65536)) //http 消息聚合
                                .addLast("handler",new HttpServerHandler()); //具体自定义
                    }
                })
                .childOption(ChannelOption.SO_KEEPALIVE,true);
        ChannelFuture f = b.bind().sync();
        System.out.println("Http Server started， Listening on " + port);
        f.channel().closeFuture().sync();

        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}
