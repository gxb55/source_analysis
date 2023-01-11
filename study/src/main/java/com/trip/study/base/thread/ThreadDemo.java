package com.trip.study.base.thread;

import java.util.concurrent.*;

/**
 * @author xbguo
 * @createTime 2022年11月26日 10:34:00
 * -XX:+PrintGCDetails
 */
public class ThreadDemo {
    static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("ThreadPool-AddOrder");
                    thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
                        System.out.println(t.getName() + "抛出异常：" + e);
                    });
                    return thread;
                }
            }, new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws Exception {
        //  test1();
        // testThreadOOM();
        //testThreadException();
        threadPoolProcess();
    }

    private static void threadPoolProcess() throws ExecutionException, InterruptedException, TimeoutException {
        Future<String> submit = singleThreadExecutor.submit(() -> {
            return "submit";
        });
        System.out.println(submit.get(10, TimeUnit.SECONDS));

        singleThreadExecutor.execute(() -> {
            System.out.println("execute");
        });

    }

    public static void testThreadException() throws Exception {
       /* Thread thread = new Thread(() -> {
            errorMethod();
        });
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println(t.getName() + "抛出异常：" + e);
        });
        thread.start();*/

       /* singleThreadExecutor.execute(() -> {
            errorMethod();
        });*/

/*        Future<?> submit = singleThreadExecutor.submit(() -> {
            errorMethod();
        });
        Object o = submit.get(10, TimeUnit.SECONDS);
        System.out.println(o);
        singleThreadExecutor.shutdown();*/
/**
 * int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler
 */


        for (int i = 0; i < 11; i++) {
            threadPoolExecutor.execute(() -> errorMethod());
        }
        threadPoolExecutor.shutdown();

        for (int i = 0; i < 11; i++) {
            singleThreadExecutor.execute(() -> errorMethod());
        }
        singleThreadExecutor.shutdown();
    }

    private static int errorMethod() {
        System.out.println(Thread.currentThread().getName());
        int x = 1 / 0;
        return x;
    }

    public static void test1() throws ExecutionException, InterruptedException, TimeoutException {
        Future<String> gxb = singleThreadExecutor.submit(() -> doSomeThing("gxb"));
        String s = gxb.get(1, TimeUnit.SECONDS);
        System.out.println(s);
        singleThreadExecutor.shutdown();
    }

    public static void testThreadOOM() throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            singleThreadExecutor.execute(() -> {
                try {
                    TimeUnit.MINUTES.sleep(1000);
                } catch (InterruptedException e) {

                }
            });
        }
        singleThreadExecutor.shutdown();
    }

    public static String doSomeThing(String a) {
        return "hello" + a;
    }
}
