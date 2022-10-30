package juc3.cf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:43:00
 */
public class FutureApiDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(4);
            return "a";
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        //String s = futureTask.get();
        String s1 = futureTask.get(3, TimeUnit.SECONDS);
        System.out.println("over");
    }
}
