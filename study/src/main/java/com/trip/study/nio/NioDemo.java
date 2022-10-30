package com.trip.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author xbguo
 * @createTime 2022年09月13日 22:31:00
 */
public class NioDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080), 1024);
        System.out.println("启动服务器");
        for (; ; ) {
            SocketChannel accept = serverSocketChannel.accept();
            System.out.println(accept.getRemoteAddress());
            Thread.sleep(200);
            accept.write(ByteBuffer.wrap("Hello World".getBytes(StandardCharsets.UTF_8)));
        }
    }
}
