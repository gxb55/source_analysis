package com.trip.algorithm.leet.some.leet2303;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xbguo
 * @createTime 2023年03月19日 22:12:00
 */
public class Solution672 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(executorService);
    }

    private static void extracted() {
        boolean completedAbruptly = true;
        boolean flag = true;
        try {
            while (flag) {

                try {

                    try {
                        int i = 1 / 0;
                    } catch (Throwable ex) {

                        throw ex;
                    }
                } finally {
                    System.out.println(1);
                }
            }
            completedAbruptly = false;
        } finally {
            System.out.println(completedAbruptly);
        }
    }

    public int flipLights(int n, int presses) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println(1);
        });
        executorService.shutdown();
        return 1;
    }
}
