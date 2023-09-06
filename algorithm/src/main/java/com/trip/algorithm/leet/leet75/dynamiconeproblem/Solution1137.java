package com.trip.algorithm.leet.leet75.dynamiconeproblem;

/**
 * @author xbguo
 * @date 2023/9/6 16:45
 */
public class Solution1137 {
    public static void main(String[] args) {
        int x=4;
        int tribonacci = Solution1137.tribonacci(x);
        System.out.println(tribonacci);
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n ];
    }
}
