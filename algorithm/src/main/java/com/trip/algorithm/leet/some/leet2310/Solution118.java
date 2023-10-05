package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年10月04日 18:43:00
 */
public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
       /* int k = 2;
        int[] prices = {2, 4, 1}; */

        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int i = solution118.maxProfit(k, prices);
        System.out.println(i);
        System.out.println(solution118.maxProfit1(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        k = Math.min(k, length / 2);
        int[][] sell = new int[length][k + 1];
        int[][] buy = new int[length][k + 1];
        // 不合法的情况
        for (int i = 1; i <= k; i++) {
            sell[0][i] = buy[0][i] = Integer.MIN_VALUE / 2;
        }
        /**
         * 我们用
         * buy[i][j]
         * 并且当前手上持有一支股票，这种情况下的最大利润；
         * 用 sell[i][j]
         * 并且当前手上不持有股票，这种情况下的最大利润。
         */
        buy[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0],  - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        int[] ints = sell[length - 1];
        int v = Arrays.stream(ints).max().getAsInt();
        return v;
    }

    public int maxProfit1(int k, int[] prices) {
        int length = prices.length;
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        k = Math.min(k, length / 2);
        int[][][] dp = new int[length][k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                // 当前手里没有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 当前手里有股票，可能是k-1次的，然后i-1下标的卖出的，本次买入操作次数+1；
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j- 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];
    }

}
