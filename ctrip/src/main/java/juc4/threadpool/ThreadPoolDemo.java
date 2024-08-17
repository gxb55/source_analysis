package juc4.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        shutdown();
    }

    private static void shutdown() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            try {
                executorService.execute(() -> doSomeThing());
                if (i == 3) {
                    // executorService.shutdown();
                    executorService.shutdown();
                    boolean b = executorService.awaitTermination(2, TimeUnit.SECONDS);
                    System.out.println("线程池是否关闭：" + b);
                    System.out.println("线程池停止了");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        System.out.println("11111111111");
    }

    private static void doSomeThing() {
        try {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
