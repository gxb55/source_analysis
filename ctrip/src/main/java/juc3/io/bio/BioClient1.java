package juc3.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author xbguo
 * @createTime 2023年02月26日 15:53:00
 */
public class BioClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        System.out.println("请输入：");
        while (true) {
            Scanner inp = new Scanner(System.in);
            String str = inp.next();
            if ("q".equals(str)) {
                break;
            }
            socket.getOutputStream().write(str.getBytes());
        }
        socket.close();
    }
}
