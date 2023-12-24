package com.trip.algorithm.leet.some.leet2312;

import java.util.Arrays;

public class Solution494 {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
       /* int[] nums = {1, 1, 1, 1, 1};
        int target = 3;*/

        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        int targetSumWays = solution494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (target > sum || target < -sum) {
            return 0;
        }
        int[][] dp = new int[length + 1][sum * 2 + 1];
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] = dp[0][sum - nums[0]]+1;
        for (int i = 1; i < length; i++) {
            int val = nums[i];
            for (int j = 0; j < dp[i].length; j++) {
                if ((j - val) >= 0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - val];
                }
                if ((j + val) < dp[i].length) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j + val];
                }
            }
        }
        return dp[length - 1][sum + target];
    }
}
