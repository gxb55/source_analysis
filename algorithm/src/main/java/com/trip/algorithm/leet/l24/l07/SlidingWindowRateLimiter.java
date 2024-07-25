package com.trip.algorithm.leet.l24.l07;

import java.util.Random;

/**
 * @author xbguo
 * @date 2024/7/24 15:31
 */
public class SlidingWindowRateLimiter {

    public static void main(String[] args) throws InterruptedException {

        int count = 100;
        int time = 1000;
        Window[] windows = new Window[time / count];
      /*  new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (checkCanPass(windows, time,  count)) {
            //    System.out.println(System.currentTimeMillis() + "通过");
            } else {
              //  System.out.println(System.currentTimeMillis() + "未通过");
            }
        }).start();*/
        while (true) {
            Thread.sleep(new Random().nextInt(50));
            Thread.sleep(new Random().nextInt(50));
            if (checkCanPass(windows, time, count)) {
           //     System.out.println(System.currentTimeMillis() + "通过");
            } else {
           //     System.out.println(System.currentTimeMillis() + "未通过");
            }
        }

    }

    private static boolean checkCanPass(Window[] windows, int time, int len) {
        long l = System.currentTimeMillis();
        long index = l % windows.length;
        long x = l % len;
        long start = l - x;
      //  System.out.println(start);
        Window window = windows[(int) index];
        if (window == null) {
            Window window1 = new Window();
            windows[(int) index] = window1;
            window1.setStartMill(start);
            window1.setCount(1);
        } else if (window.getStartMill() < start) {
            window.setStartMill(start);
            window.setCount(1);
        }else {
            window.setCount(window.getCount()+1);
        }
        long count = 0;
        for (Window window1 : windows) {
            if (window1 == null) {
                continue;
            }
            if (window1.getStartMill() < l) {
                count += window1.getCount();
            }
        }
        boolean b = (count ) <= 10;
        System.out.println((count ) + ":" + 10+":"+b);
        return b;
    }

}

class Window {

    private Integer count;
    private long startMill;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public long getStartMill() {
        return startMill;
    }

    public void setStartMill(long startMill) {
        this.startMill = startMill;
    }
}