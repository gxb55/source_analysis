package com.train.ctrip.juc3.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年06月04日 21:37:00
 */
public class CompletableFutureFastDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> aFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "A ";
        });
        CompletableFuture<String> bFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B ";
        });
        CompletableFuture<Void> voidCompletableFuture = aFuture.acceptEither(bFuture, x -> {
            System.out.println(x + "is winner");
        });
        System.out.println(voidCompletableFuture.get());

    }
}
