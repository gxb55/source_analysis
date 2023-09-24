package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @createTime 2023年09月17日 09:56:00
 */
public class Solution198 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][2];
        for (int i = 0; i < nums.length; i++) {
            // 当前不偷
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            // 当前偷
            dp[i + 1][1] = dp[i][0] + nums[i];
        }
        return Math.max(dp[len][1], dp[len][0]);
    }
}
