package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @createTime 2023年10月05日 22:11:00
 */
public class Solution309 {
    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        //int[] prices = {1, 2, 3, 0, 2};
        int[] prices = {2, 1, 4};
        int i = solution309.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
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
            //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if ((i - 2) >= 0) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[len - 1][0];
    }
}
