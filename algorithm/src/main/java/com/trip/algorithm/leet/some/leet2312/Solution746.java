package com.trip.algorithm.leet.some.leet2312;

public class Solution746 {
    public static void main(String[] args) {
       // int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] arr = {10,15,20};
        int i = minCostClimbingStairs(arr);
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 1) {
            return cost[0];
        } else if (length == 2) {
            return Math.min(cost[1], cost[0]);
        }
        int[] dp = new int[length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            if (i < cost.length) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            }

        }
        return dp[length];
    }
}
