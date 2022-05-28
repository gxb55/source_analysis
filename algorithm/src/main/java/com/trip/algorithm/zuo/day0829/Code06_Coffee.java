package com.trip.algorithm.zuo.day0829;

/**
 * 洗咖啡杯的问题，京东面试原题
 * 【】 arr 代表喝完咖啡的时间点
 * a 洗一杯咖啡的所需时间
 * b 自然挥发干一杯咖啡的时间
 * 问 arr最小杯子干净的计划
 */
public class Code06_Coffee {
    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 5, 7, 10, 12, 12, 12, 12, 12, 12, 15};
        int a = 3;
        int b = 10;
        int process = process(arr, a, b, 0, 0);
        int dp = dp(arr, a, b);
        System.out.println(process);
        System.out.println(dp);
    }

    /**
     * @param drinks   喝完咖啡的时间点 固定参数
     * @param a        洗咖啡杯所需时间 固定参数
     * @param b        自然晾干咖啡杯所需时间 固定参数
     * @param index    当前来到了第几个咖啡杯，即 0 - index-1 位置上面的咖啡杯都洗好了
     * @param washLine 如果要洗咖啡杯所需要的等待时间
     * @return
     */
    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        // 现在到底了最后一个杯子，这个杯子前面决策好了，其实就是问，这个杯子是风干好还是洗好快
        if (index == drinks.length - 1) {
            return Math.min(
                    // 风干所需时间
                    drinks[index] + b,
                    // 洗完所需时间
                    Math.max(drinks[index] + a, washLine + a)
            );
        }
        // 杯子先洗
        int wash = Math.max(drinks[index], washLine) + a;
        int process = process(drinks, a, b, index + 1, wash);
        int p1 = Math.max(process, wash);

        // 杯子风干，喝完才能风干
        int dry = drinks[index] + b;
        int process1 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(process1, dry);
        // 递归展开，每一个杯子判断 风干好  洗好 哪个快？
        return Math.min(p1, p2);
    }


    /**
     * 动态规划解决洗咖啡杯的问题，问题规模，可变参数做矩阵
     *
     * @param drinks
     * @param a      洗咖啡杯的时间
     * @param b      风干咖啡杯的时间
     * @return
     */
    public static int dp(int[] drinks, int a, int b) {
        int n = drinks.length;
        // 即风干更快，则直接求出结果
        if (b <= a) {
            return drinks[n - 1] + b;
        }
        // 列限制，即所有的咖啡杯都去洗所需的时间
        int limit = 0;
        for (Integer integer : drinks) {
            limit = Math.max(limit, integer) + a;
        }

        /**
         * x 0-n
         * limit 0-limit
         */
        int dp[][] = new int[n][limit + 1];
        for (int washLine = 0; washLine <= limit; washLine++) {
            dp[n - 1][washLine] = Math.min(
                    // 风干时间
                    drinks[n - 1] + b,
                    // 洗干时间
                    Math.max(washLine, drinks[n - 1]) + a
            );
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= limit; j++) {
                int p1 = Integer.MAX_VALUE;
                int wash = Math.max(drinks[i], j) + a;
                if (wash <= limit) {
                    int process = dp[i + 1][wash];
                    p1 = Math.max(process, wash);
                }


                // 杯子风干，喝完才能风干
                int dry = drinks[i] + b;
                int process1 = dp[i + 1][j];
                int p2 = Math.max(process1, dry);
                dp[i][j] = Math.min(p1, p2);
            }
        }

        System.out.println("------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("------");
        return dp[0][0];
    }
}
