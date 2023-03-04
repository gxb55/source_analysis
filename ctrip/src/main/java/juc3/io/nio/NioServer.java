package juc3.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年02月26日 19:26:00
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        List<SocketChannel> list = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",6379));
        while (true){
            SocketChannel accept = serverSocketChannel.accept();
            if(accept!=null){
                accept.configureBlocking(false);
                list.add(accept);
            }
            for (SocketChannel socketChannel:list){
                int read = socketChannel.read(byteBuffer);
                if(read>0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[read];
                    byteBuffer.get(bytes);
                    System.out.println(new String(bytes));
                    byteBuffer.clear();
                }
            }
        }
    }
}
