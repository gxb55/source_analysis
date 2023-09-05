package com.trip.algorithm.leet.leet75.dynamiconeproblem;

/**
 * @author xbguo
 * @date 2023/9/5 19:35
 */
public class Solution198 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int max = 0;
        int length = nums.length;
        //0 不偷；1 偷
        int[][] dp = new int[length + 1][2];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            dp[i + 1][1] = dp[i][0] + num;
            max = Math.max(dp[i + 1][0], max);
            max = Math.max(dp[i + 1][1], max);
        }
        return max;
    }
}
