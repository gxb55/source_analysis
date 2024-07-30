package juc4.threadlocal;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        Su7 su7 = new Su7();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                int i1 = new Random().nextInt(4) + 1;
                for (int j = 1; j <=i1 ; j++) {
                    su7.sale();
                    su7.personSale();
                }
                System.out.println(su7.threadLocal.get());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        Integer total = su7.getTotal();
        System.out.println(total);
    }

    private static void m1() throws InterruptedException {
        Su7 su7 = new Su7();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                int i1 = new Random().nextInt(4) + 1;
                for (int j = 1; j <i1 ; j++) {
                    su7.sale();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        Integer total = su7.getTotal();
        System.out.println(total);
    }
}
