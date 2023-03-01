package com.train.ctrip.juc3.interrupt;

/**
 * @author xbguo
 * @createTime 2022年06月11日 09:23:00
 */
public class InterruptDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted: " + Thread.currentThread().isInterrupted());
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    /**
                     * // 为什么sleep api会抛出异常，就是因为当A线程在sleep的时候，B线程调用了A线程的interrupt方法
                     *   //A线程的sleep就会抛出异常，并且interrupt的标志位会被重置
                     *     当抛出异常的时候需要自己，手动打断自己
                     */
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            thread.interrupt();
        }).start();
    }
}
