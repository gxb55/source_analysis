package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年08月14日 17:26:00
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 通过次数144,283提交次数341,952
 */
public class Solution188 {
    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        int k = 2;
        int[] prices = {2, 4, 1};

       /* int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};*/
        int i = solution188.maxProfit(k, prices);
        System.out.println(i);
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2 * k];

        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = -prices[0];
            }
        }
        // 偶数是第n次买入 奇数是卖出
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k; j++) {
                //当前下标第一次买入，则就是比较，当前买入和上一次买入哪个小
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else {
                    if (j % 2 == 0) {
                        //买入 = 上一次买入||上一次卖出，本次买入
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                    } else {
                        //卖出 = 上一次卖出||上一次买入，本次卖出
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                    }
                }
            }
        }
        return dp[len - 1][2 * k - 1];
    }
}
