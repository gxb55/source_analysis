package com.trip.study.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author xbguo
 * @createTime 2022年09月19日 22:05:00
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        Selector selector = Selector.open();
        sc.connect(new InetSocketAddress(9000));
        sc.register(selector, SelectionKey.OP_CONNECT);
        System.out.println("客户端启动了！");

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                handle(next);
            }
        }
    }

    private static void handle(SelectionKey key) throws IOException {
        if (key.isConnectable()) {
            System.out.println(System.currentTimeMillis());
            SocketChannel sc = (SocketChannel) key.channel();
            if (sc.isConnectionPending()) {
                sc.finishConnect();
            }
            sc.configureBlocking(false);
            ByteBuffer send = ByteBuffer.wrap("Hello World".getBytes());
            sc.write(send);
            sc.register(key.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (key.isReadable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer send = ByteBuffer.allocate(1024);
            int len = sc.read(send);
            if (len != -1) {
                System.out.println(System.currentTimeMillis() + ":收到来自服务端数据：" + new String(send.array(), 0, len));
            }
        } else if (key.isWritable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            Scanner scan = new Scanner(System.in);
            String read = scan.nextLine();
            ByteBuffer send = ByteBuffer.wrap(read.getBytes());
            sc.write(send);
            sc.register(key.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }
}

