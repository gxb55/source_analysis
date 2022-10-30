package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年08月14日 18:15:00
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
 * 通过次数200,045提交次数314,907
 */
public class Solution309 {
    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        int[] prices = {1, 2, 3, 0, 2};
        int i = solution309.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        //0：买入；1：卖出；
        for (int i = 1; i < len; i++) {
            if (i - 1 > 0) {
                //当天买入=昨天买入||前天卖出的，今天买入
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            } else {
                //当天买入=昨天买入||前天卖出的 但是前天不存在，今天买入
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            }
            //当天卖出=昨天卖出||昨天买入，今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}