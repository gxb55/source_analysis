package com.trip.algorithm.leet.leet75.dynamiconeproblem;

/**
 * @author xbguo
 * @date 2023/9/5 19:46
 */
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 =new Solution213();
        int[] nums = {1,2,3,1};
        int rob = solution213.rob(nums);
        System.out.println(rob);

    }
    public int rob(int[] nums) {
        int[] arr =new int[nums.length-1];
        int[] arr1 =new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
            arr[i]=nums[i];
        }
        int j=0;
        for (int i = 1; i < nums.length; i++) {
            arr1[j++]=nums[i];
        }
        return Math.max(rob1(arr1),rob1(arr));
    }
    public int rob1(int[] nums) {
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
