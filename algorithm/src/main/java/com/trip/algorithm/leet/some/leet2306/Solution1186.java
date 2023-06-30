package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @date 2023/6/27 14:05
 */
public class Solution1186 {
    public static void main(String[] args) {
        //   int[] arr = {1, -2, 0, 3};
        int[] arr = {-1, -2, -1, -3};
        int i = maximumSum(arr);
        System.out.println(i);
    }

    public static int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i][0] = arr[i];
                dp[i][1] = 0;
                max = Math.max(max, dp[i][0]);
            } else {
                int val = dp[i - 1][0];
                if (val >= 0) {
                    dp[i][0] = val + arr[i];
                } else {
                    dp[i][0] = arr[i];
                }
                // 上一次删除了一个再把本次的加上||上一次未删除，不加本次的元素
                dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
                max = Math.max(max, dp[i][0]);
                max = Math.max(max, dp[i][1]);
            }

        }
        return max;
    }
}
