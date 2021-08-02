package com.trip.study.juc.callAble;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Runnableimpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run方法");
    }
}

class CallableImpl implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "hello world";
    }
}

/**
 * Runnable
 * Callable
 * 两个接口
 */
public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnableimpl run =  new Runnableimpl();
        CallableImpl callable =  new CallableImpl();

        new Thread(run,"A").start();
        // Runnable
        FutureTask task = new FutureTask(callable);
        new Thread(task,"B").start();

        Object o = task.get();
        System.out.println(o);
        // jdk1.8新提供的带返回值的接口，功能更加强大
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName()+ "CompletableFuture";
        });
        System.out.println(completableFuture1.get());
    }
}
