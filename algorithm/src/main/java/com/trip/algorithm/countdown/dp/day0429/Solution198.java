package com.trip.algorithm.countdown.dp.day0429;

/**
 * @author xbguo
 * @createTime 2023年04月29日 09:54:00
 * 动态规划一维数组，可以用状态压缩的解法
 */
public class Solution198 {
    public static void main(String[] args) {
        //  int[] arr = {1, 2, 3, 1};
        int[] arr = {1, 3, 1, 3, 100};
        int rob = rob(arr);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(nums[0], dp[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
