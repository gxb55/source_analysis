package com.trip.algorithm.leet.l24.l02;

public class Solution53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
