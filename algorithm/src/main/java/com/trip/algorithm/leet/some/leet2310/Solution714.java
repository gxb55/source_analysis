package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @createTime 2023年10月06日 08:23:00
 */
public class Solution714 {
    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
       /* int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2; */

        int[] prices = {1,3,7,5,10,3};
        int fee = 3;
        int i = solution714.maxProfit(prices, fee);
        System.out.println(i);
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        // 当天手里没有股票
        dp[0][0] = 0;
        // 当天手里有股票
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            //卖出的时候计算手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
