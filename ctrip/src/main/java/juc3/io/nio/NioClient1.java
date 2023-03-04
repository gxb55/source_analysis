package juc3.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author xbguo
 * @createTime 2023年02月26日 19:33:00
 */
public class NioClient1 {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",6379));
        System.out.println("请输入：");
        while (true) {
            Scanner inp = new Scanner(System.in);
            String str = inp.next();
            if ("q".equals(str)) {
                break;
            }
            socketChannel.write(ByteBuffer.wrap(str.getBytes()));
        }
        socketChannel.close();
    }
}
