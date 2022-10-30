package com.trip.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年09月13日 22:52:00
 */
public class NioWithSelectorDemo {
    public static void main(String[] args) throws  Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress(8080),1024);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("启动服务器");
        for (;;){
            selector.select();
            Set<SelectionKey> keys = selector.keys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = serverSocketChannel.accept();
                    System.out.println(accept.getRemoteAddress());
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_ACCEPT);
                }else if(next.isWritable()){
                    SocketChannel socketChannel1= (SocketChannel) next.channel();
                    Thread.sleep(200);
                    socketChannel1.write(ByteBuffer.wrap("hello world".getBytes(StandardCharsets.UTF_8)));

                }
            }
        }

    }
}
