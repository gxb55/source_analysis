package com.trip.algorithm.leet.leet75.dynamiconeproblem;

/**
 * @author xbguo
 * @date 2023/9/6 19:09
 */
public class Solution714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int i = maxProfit(prices, fee);
        System.out.println(i);
    }

    public  static int maxProfit(int[] prices, int fee) {
        //0 当天卖出；1当天买入
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i] - fee);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length][0];

    }
}
