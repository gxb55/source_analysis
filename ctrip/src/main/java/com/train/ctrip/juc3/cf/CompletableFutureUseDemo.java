package com.train.ctrip.juc3.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年06月04日 19:49:00
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = ThreadLocalRandom.current().nextInt(20);
            System.out.println(i);
            return i;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("whenComplete " + v);
            }
        }).exceptionally(e -> {
           // System.out.println(e);
            return null;
        });
        Integer integer = exceptionally.get();
        System.out.println(integer);
        System.out.println("over");
    }
}
