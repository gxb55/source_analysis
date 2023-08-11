package com.trip.algorithm.leet.some.Leet2308;

/**
 * @author xbguo
 * @createTime 2023年08月08日 08:24:00
 */
public class Solution1947 {
    public static void main(String[] args) {
        //  int[] arr = {1, -3, 2, 3, -4};
        //  int[] arr = {2,-5,1,-4,3,-2}; , -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9
        int[] arr = {-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        int i = maxAbsoluteSum(arr);
        System.out.println(i);

        Solution1947 solution1947 = new Solution1947();
    }


    public static int maxAbsoluteSum(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // 0是正的；1是负的
        dp[0][0] = Math.max(nums[0],0);
        dp[0][1] = Math.min(nums[0],0);
        int max = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if((num+dp[i-1][0])>num){
                dp[i][0] = num+dp[i-1][0];
            }else{
                dp[i][0] = num;
            }
            dp[i][0]=Math.max(dp[i][0],0);
            if((num+dp[i-1][1])<num){
                dp[i][1] = num+dp[i-1][1];
            }else{
                dp[i][1] = num;
            }
            dp[i][1]=Math.min(dp[i][1],0);
            max = Math.max(Math.abs(dp[i][0]), max);
            max = Math.max(Math.abs(dp[i][1]), max);
        }

        return max;
    }
}
