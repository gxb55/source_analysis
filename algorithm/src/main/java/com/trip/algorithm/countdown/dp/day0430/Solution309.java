package com.trip.algorithm.countdown.dp.day0430;

/**
 * @author xbguo
 * @createTime 2023年04月30日 10:51:00
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 通过次数251,383提交次数391,969
 */
public class Solution309 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length + 1][4];
        // 当天只能买入股票
        dp[1][1] = -prices[0];
        /**
         * 1 买入
         * 2 冻结 卖出
         * 3 非冻结的 卖出
         */
        for (int i = 1; i < length; i++) {
            // 卖出股票后，你无法在第二天买入股票
            // 当天的买入 = 昨天的买入 || 昨天非冻结的卖出+今天的买入
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][3] - prices[i]);
            // 冻结的卖出 = 昨天买入，今天卖出
            dp[i + 1][2] = dp[i][1] + prices[i];
            // 非冻结的卖出 = 昨天冻结的卖出 || 昨天非冻结的卖出
            dp[i + 1][3] = Math.max(dp[i][2], dp[i][3]);
        }
        return Math.max(dp[length][2], dp[length][3]);
    }
}
