package com.trip.atguigu.reactor.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

public class EchoServer {
    public static final int port = 8088;

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .option(ChannelOption.SO_BACKLOG, 1024)
                /* .option(ChannelOption.SO_REUSEADDR)*/
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
        bossGroup.shutdownGracefully().sync();
        workGroup.shutdownGracefully().sync();
    }
}
/**
 * 
 * nio Demo https://blog.csdn.net/oFangFeiMeng1/article/details/131320426
 * 
 * 
 *               1.// 创建一个ServerSocketChannel实例
 *              ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) 
 *
 *             // 设置为非阻塞模式
 *             serverSocketChannel.configureBlocking(false);
 *             2.// 绑定端口
 *             serverSocketChannel.socket().bind(new InetSocketAddress(8080));
 *             // 注册到Selector，监听ACCEPT事件
 *             3.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
 *
 *             
 *                 // 阻塞等待就绪的事件
 *               4. selector.select(TIMEOUT)
 * 
 *  1.initAndRegister()
 *      1.1 channelFactory.newChannel()  初始化channel，初始化pipeline，初始化head tail
 *      1.2 init(channel); 设置属性，设置option
 *      1.3 config().group().register(channel);
 *          safeSetSuccess(promise);
 *          javaChannel().register(eventLoop().unwrappedSelector(), 0, this); 设置ChannelFuture为成功
 *  2.doBind0(regFuture, channel, localAddress, promise);
 *      2.1 HeadContext#bind(io.netty.channel.ChannelHandlerContext, java.net.SocketAddress, io.netty.channel.ChannelPromise)
 *          2.1.1 AbstractUnsafe#bind(java.net.SocketAddress, io.netty.channel.ChannelPromise)
 *              2.1.1.1 DefaultChannelPipeline#fireChannelActive()
 *                  2.1.1.1.1 HeadContext#channelActive(io.netty.channel.ChannelHandlerContext)
 *                      2.1.1.1.1 io.netty.channel.nio.AbstractNioChannel#doBeginRead()
 */