package juc3.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年06月04日 20:34:00
 */
public class CompletableFutureApi2Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //m1();
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            int i = ThreadLocalRandom.current().nextInt(10);
            try {
                System.out.println(Thread.currentThread().getName() + "  begin: " + i);
                TimeUnit.MILLISECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        });
        System.out.println(completableFuture.join());
    }

    private static void m1() {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            int i = ThreadLocalRandom.current().nextInt(10);
            try {
                System.out.println(Thread.currentThread().getName() + "  begin: " + i);
                TimeUnit.MILLISECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }).thenApply(e -> {
            return e + 3;
        }).thenApply(e -> {

            return e + 4;
        }).handle((v, e) -> {
            if (v > 5) {
                int i = v / 0;
            }
            return v;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算出结果为：" + v);
            }
        }).exceptionally(e -> {
            System.out.println("异常：" + e);
            return null;
        });
        System.out.println("主线程干别的事情");
        System.out.println(completableFuture.join());
    }
}
