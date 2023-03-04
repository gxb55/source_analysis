package juc3.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xbguo
 * @createTime 2023年02月26日 15:49:00
 */
public class BioService {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(6379);
        System.out.println("启动监听端口：");
        while (true) {
            Socket socket1 = socket.accept();
            InputStream inputStream = socket1.getInputStream();
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        }
    }
}
