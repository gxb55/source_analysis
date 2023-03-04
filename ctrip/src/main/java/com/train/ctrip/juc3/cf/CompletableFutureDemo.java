package com.train.ctrip.juc3.cf;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:06:00
 *
 * future 实现了runnable callable接口，
 * FutureTask，构造需要一个callable接口，因为他实现了runnable接口，所以可以直接用线程运行
 * 线程运行，具体执行了什么，其实就是去执行callable接口的方法，将方法的返回值放入对象中
 * get获取对象
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.printf( futureTask.get());
        CompletableFuture<String> future = new CompletableFuture<>();
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "hello";
    }
}