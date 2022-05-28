package com.trip.algorithm.zuo.trainingcamp3.class03;

/**
 * 背包容量为w
 * 一共有n袋零食, 第i袋零食体积为v[i]
 * 总体积不超过背包容量的情况下，
 * 一共有多少种零食放法？(总体积为0也算一种放法)。
 */
public class Code02_SnacksWays {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 9};
        int v = 8;
        int result = getResult(arr, v);
        System.out.println(result);
        int i = ways3(arr, v);
        System.out.println(i);
    }

    public static int getResult(int[] arr, int v) {
        if (arr == null || arr.length < 1 || v < 1) {
            return 0;
        }
        return getNums(arr, 0, v);
    }

    /**
     * @param arr
     * @param i
     * @param v
     * @return
     */
    private static int getNums(int[] arr, int i, int v) {
        if (v < 0) {
            return 0;
        }
        if (i == arr.length) {
            return 1;
        }
        return getNums(arr, i + 1, v - arr[i]) + getNums(arr, i + 1, v);
    }

    public static int ways3(int[] arr, int w) {
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= w) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - arr[i]) >= 0 ? dp[i - 1][j - arr[i]] : 0);
            }
        }
        int ans = 0;
        for (int j = 0; j <= w; j++) {
            ans += dp[N - 1][j];
        }
        return ans;
    }
}
