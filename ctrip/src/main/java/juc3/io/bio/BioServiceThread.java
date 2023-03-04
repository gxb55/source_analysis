package juc3.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xbguo
 * @createTime 2023年02月26日 15:49:00
 */
public class BioServiceThread {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(14);
        ServerSocket socket = new ServerSocket(6379);
        System.out.println("启动监听端口：");
        while (true) {
            Socket socket1 = socket.accept();
            executorService.execute(()->{
                InputStream inputStream = null;
                try {
                    inputStream = socket1.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while ((len = inputStream.read(bytes)) != -1) {
                        System.out.println(new String(bytes, 0, len));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
