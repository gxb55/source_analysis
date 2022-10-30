package juc3.interrupt;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xbguo
 * @createTime 2022年06月09日 22:35:00
 */
public class InterruptDemo {
    static volatile boolean flag = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        // m1();
        //m2();
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println("111");
            }
        });
        t1.start();
        Thread.sleep(100);
        new Thread(() -> {
            t1.interrupt();
        }).start();
    }

    private static void m2() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    break;
                }
                System.out.println("111");
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            atomicBoolean.set(true);
        }).start();
    }

    private static void m1() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (flag) {
                    break;
                }
                System.out.println("111");
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            flag = true;
        }).start();
    }
}
