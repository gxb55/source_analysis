package com.train.ctrip.juc3.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author xbguo
 * @createTime 2022年06月04日 21:21:00
 */
public class CompletableFutureApi3Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApplyAsync(x -> {
            System.out.println("thenApply我有返回值，我接受参数，并且处理，并且返回一定的内容");
            return x + 1;
        }).thenAccept(x -> {
            System.out.println(x);
            System.out.println("thenAccept我没有返回值，我接受参数");
        }).thenRun(() -> {
            System.out.println("我跟他们没关系，我去做另外的事情");
        });

        System.out.println(voidCompletableFuture.get());
    }
}
