package com.trip.algorithm.leet.some.leet2312;

public class Solution70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // 第0到第一只有一种方法
        dp[1] = 1;
        // 第0到第二有两种，1从0到二；2从0到一到2
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
