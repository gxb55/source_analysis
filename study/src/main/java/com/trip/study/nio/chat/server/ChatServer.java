package com.trip.study.nio.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年09月25日 18:13:00
 */
public class ChatServer {
    public void startServer() throws Exception {
        //1.创建selector
        Selector selector = Selector.open();
        //2.serversocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3.channel绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8099));
        serverSocketChannel.configureBlocking(false);
        //4.查询就绪事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功了！");
        //5.根据就绪状态，调用对应的具体操作
        for (; ; ) {
            int readChannels = selector.select();
            if (readChannels == 0) {
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    acceptOperator(serverSocketChannel, selector);
                }
                if (selectionKey.isReadable()) {
                    readOperator(selector, selectionKey);
                }
                if(selectionKey.isWritable()){
                    System.out.println("可写事件");
                }
            }
        }
        //6.
    }

    private void readOperator(Selector selector, SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while (channel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            stringBuilder.append(new String(byteBuffer.array()));
        }
        //channel.register(selector, SelectionKey.OP_READ);
        // 广播给其他的channel
        if (stringBuilder.length() > 0) {
            System.out.println(stringBuilder);
            castOtherClient(stringBuilder.toString(), selector, channel);
        }
    }

    private void castOtherClient(String toString, Selector selector, SocketChannel channel) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey selectionKey : keys) {
            if (selectionKey.channel() instanceof SocketChannel && selectionKey.channel() != channel) {
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                socketChannel.write(Charset.forName("UTF-8").encode(toString));
            }
        }
    }

    /**
     * 处理链接事件
     *
     * @param serverSocketChannel
     * @param selector
     */
    private void acceptOperator(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        SocketChannel channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("欢迎进入聊天室，请注意隐私！".getBytes());
        // channel.write(allocate);
        channel.write(Charset.forName("UTF-8").encode("欢迎进入聊天室，请注意隐私！"));
    }

    public static void main(String[] args) throws Exception {
        new ChatServer().startServer();
    }
}
