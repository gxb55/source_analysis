package com.trip.study.nio.chat.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xbguo
 * @createTime 2022年09月25日 21:26:00
 */
public class ClientThread implements Runnable {
    private Selector selector;

    public ClientThread(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int select = selector.select();
                if (select == 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isReadable()) {
                        readOperator(selector, selectionKey);
                    }
                    if(selectionKey.isWritable()){
                        System.out.println("可写事件");
                    }
                }
            }
        } catch (Exception e) {
    System.out.println(e);
        }
    }

    private void readOperator(Selector selector, SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while (channel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            stringBuilder.append(new String(byteBuffer.array()));
        }
        // 广播给其他的channel
        if (stringBuilder.length() > 0) {
            System.out.println(stringBuilder);
        }
    }
}
