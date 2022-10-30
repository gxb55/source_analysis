package juc3.base;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:00:00
 */
public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            boolean daemon = Thread.currentThread().isDaemon();
            System.out.println("当前进程是否是守护进程：" + daemon);
            while (true) {

            }
        }, "t1");
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(100);
    }
}
