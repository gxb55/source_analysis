package juc3.cf;

import java.util.concurrent.CompletableFuture;

/**
 * @author xbguo
 * @createTime 2022年06月04日 21:42:00
 */
public class CompletableFutureCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenApply(x->{
            return x+1;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            return 20;
        }), (x, y) -> {
            System.out.println(x + y);
            return x + y;
        });

        System.out.println(integerCompletableFuture.join());
    }
}
