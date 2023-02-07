package com.trip.algorithm.codethink.greedyalgorithm;

/**
 * @author xbguo
 * @date 2023/2/7 16:54
 */
public class Solution122 {
    public static void main(String[] args) {
     //   int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr = {1,2,3,4,5};
      //  int[] arr = {7,6,4,3,1};
        int i = Solution122.maxProfit(arr);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        //0 买入-；1 卖出+；2 不操作
        int[][] dp = new int[3][len + 1];
        for (int i = 0; i < len; i++) {
            int val = prices[i];
            if (i == 0) {
                dp[0][i] = -val;
                dp[1][i] = 0;
            } else {
                dp[0][i] = Math.max(dp[1][i - 1] - val,dp[0][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1] + val,dp[1][i - 1]);
            }

        }
        return Math.max(dp[0][len-1],dp[1][len-1]);
    }
}
