package juc4.threadpool;

import java.util.concurrent.*;

public class ThreadPoolDoDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> submit = executorService.submit(() -> {
            return 0;
        });
        submit.get();
        executorService.shutdown();
    }
}
