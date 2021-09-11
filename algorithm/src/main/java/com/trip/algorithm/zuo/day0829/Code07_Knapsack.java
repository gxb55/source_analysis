package com.trip.algorithm.zuo.day0829;

/**
 * 经典背包问题
 * 0 1 背包
 */
public class Code07_Knapsack {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        int[] v = {5, 4, 3, 2, 1};
        int process = process(w, v, 0, 0, 15);
        int process1 = process(w, v, 0, 15);
        int dp = dp(w, v, 0, 15);
        int dp1 = dp1(w, v, 0, 15);
        // System.out.println(process);
        //System.out.println(process1);
        System.out.println(dp);
        System.out.println(dp1);
    }

    /**
     * @param weight   重量数组
     * @param value    价值数组
     * @param index    下标
     * @param alreadyW 背包已经装了多少重量
     * @param bag      背包的最大容量，重量的
     * @return
     */
    public static int process(int[] weight, int[] value, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        if (index == weight.length) {
            return 0;
        }
        int process = process(weight, value, index + 1, alreadyW + weight[index], bag);
        if (process != -1) {
            process += value[index];
        }
        int res = process(weight, value, index + 1, alreadyW, bag);
        return Math.max(process, res);
    }

    /**
     * @param weight
     * @param value
     * @param index
     * @param rest   剩余容量
     * @return
     */
    public static int process(int[] weight, int[] value, int index, int rest) {
        //说明当前货物不能要
        if (rest < 0) {
            return -1;
        }
        // 表示当前货物可以要，并且当前这个分支结束了
        if (index == value.length) {
            return 0;
        }
        // 要了当前货物，则有可能超出背包容量需要判断，如果没有超出容量则把价值加上去
        int p1 = process(weight, value, index + 1, rest - weight[index]);
        if (p1 != -1) {
            p1 = p1 + value[index];
        }
        // 不要当前货物，肯定不会超出容量，价值没有增加
        int p2 = process(weight, value, index + 1, rest);
        return Math.max(p2, p1);
    }

    /**
     * @param weight 重量数组 1 2 3 4 5
     * @param value  价值数组 5 4 3 2 1
     * @param n  下标 从0开始
     * @param bag   剩余容量 15
     * @return
     */
    public static int dp(int[] weight, int[] value, int n, int bag) {
        int N = value.length;
        int[][] dp = new int[N + 1][bag + 1];

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                if ((rest >= weight[index])) {
                    p2 = dp[index + 1][rest - weight[index]] + value[index];
                }
                dp[index][rest] = Math.max(p2, p1);
            }
        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return dp[0][bag];
    }


    public static int dp1(int[] weight, int[] value, int n, int bag) {
        int N = value.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                if (rest - weight[index] >= 0) {
                    p2 = dp[index + 1][rest - weight[index]] + value[index];
                }
                dp[index][rest] = Math.max(p2, p1);
            }
        }

        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return dp[0][bag];
    }
}
