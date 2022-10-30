package juc3.base;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:03:00
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        }, "t1");
        thread.start();
    }
}
