package com.trip.algorithm.leet.zs;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2022年07月02日 15:48:00
 * <p>
 * 题目：
 * 条件一：数组Arr=[3,2,7]代表3太咖啡机制作一杯咖啡的时间
 * 条件二：N代表有N个人排队喝咖啡，一人一杯，来的人三个咖啡机后边都可以排队
 * 条件三：a代表洗咖啡杯的机器洗一个杯子需要的时间(只有一个洗咖啡杯机器，一次只洗一个杯子)
 * 条件四：b代表一个咖啡杯不适用机器清洗，自然挥发变干净的时间
 * 条件五：店里的咖啡杯超过N个
 * <p>
 * 问:从第一个人去泡咖啡开始，到杯子全部变干净至少耗时多久
 */
public class Solution_Coffee {
    public static void main(String[] args) {
        Solution_Coffee solution_coffee = new Solution_Coffee();
        int[] arr = {2, 3, 7};
        int i = solution_coffee.makeCoffee(5, arr, 2, 3);
        System.out.println(i);
    }

    /**
     * @param n   n个人需要喝咖啡
     * @param arr 每个咖啡机制作咖啡所需时间
     * @param a   洗一个咖啡杯需要的时间
     * @param b   自然挥发需要的时间
     */
    public int makeCoffee(int n, int[] arr, int a, int b) {
        PriorityQueue<WaitCoffee> queue = new PriorityQueue<WaitCoffee>((x, y) -> {
            return x.getCoffeeTime() - y.getCoffeeTime();
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(new WaitCoffee(0, arr[i]));
        }
        // 每个人喝完的最优时间
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            WaitCoffee poll = queue.poll();
            dp[i] = poll.getCoffeeTime();
            queue.add(new WaitCoffee(poll.getCoffeeTime(), poll.time));
        }
        return process(dp, a, b, 0, 0);
    }

    /**
     * @param dp
     * @param a        洗一个咖啡杯需要的时间
     * @param b        自然挥发需要的时间
     * @param index
     * @param waitTime
     * @return
     */
    private int process(int[] dp, int a, int b, int index, int waitTime) {
        if (index == dp.length - 1) {
            int p2 = dp[index] + b;
            // 我可以洗的时间和我要等待的时候取最大值，两个都满足的时候才可以去洗
            int p1 = Math.max(waitTime, dp[index]) + a;
            int min = Math.min(p1, p2);
            System.out.println(min);
            return min;
        }
        /**
         * 决定用机器洗
         */
        int machine = Math.max(waitTime, dp[index]) + a;
        int next1 = process(dp, a, b, index + 1, machine);
        int p1 = Math.max(next1, machine);
        /**
         * 决定自然风干
         */
        int dry = dp[index] + b;
        int next2 = Math.max(dry, process(dp, a, b, index + 1, waitTime));
        int p2 = Math.max(next2, dry);
        return Math.min(p1, p2);
    }

    class WaitCoffee {
        /**
         * 什么时候可以去制作咖啡
         */
        private int begin;
        /**
         * 开始制作后多久可以喝到咖啡
         */
        private int time;

        /**
         * 用户如果选择这个机器，用户多久可以喝到咖啡
         *
         * @return
         */
        public int getCoffeeTime() {
            return begin + time;
        }

        public WaitCoffee(int begin, int time) {
            this.begin = begin;
            this.time = time;
        }
    }
}
