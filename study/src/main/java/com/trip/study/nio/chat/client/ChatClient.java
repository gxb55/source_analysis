package com.trip.study.nio.chat.client;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author xbguo
 * @createTime 2022年09月25日 18:13:00
 */
public class ChatClient {

    public void startClient(String name) throws Exception {
        //1.链接服务端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8099));

        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new ClientThread(selector)).start();

        //2.向服务端发送消息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            if (msg.length() > 0) {
                socketChannel.write(Charset.forName("UTF-8").encode(name + ":" + msg));
            }
        }
        //3.接收服务端响应信息
    }

    public static void main(String[] args) throws Exception {
        new ChatClient().startClient("ChatClient");
    }
}
