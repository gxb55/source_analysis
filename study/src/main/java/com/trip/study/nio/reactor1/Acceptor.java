package com.trip.study.nio.reactor1;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xbguo
 * @createTime 2022年09月14日 21:55:00
 * 接收链接
 */
public class Acceptor implements Runnable{

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public Acceptor(ServerSocketChannel serverSocketChannel, Selector selector) {
        this.serverSocketChannel = serverSocketChannel;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel accept = serverSocketChannel.accept();
            if(accept!=null){
                System.out.println(String.format("收到来自 %s 的连接",
                        accept.getRemoteAddress()));
                // 同步处理，单线程
               // new Handler(accept,selector);
                //这里把客户端通道传给Handler，Handler负责接下来的事件处理（除了连接事件以外的事件均可）
                new AsyncHandler(accept, selector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
