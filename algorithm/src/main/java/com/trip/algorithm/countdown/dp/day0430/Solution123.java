package com.trip.algorithm.countdown.dp.day0430;

/**
 * @author xbguo
 * @createTime 2023年04月30日 09:59:00
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 * <p>
 * 输入：prices = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 * 通过次数252,056提交次数430,201
 */
public class Solution123 {
    public static void main(String[] args) {
        //int[] arr = {7, 6, 4, 3, 1};
        int[] arr = {1, 2, 3, 4, 5};
        int i = maxProfit(arr);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][5];
        dp[1][1] = -prices[0];
        dp[1][3] = -prices[0];
        /**
         * 1 第一次买入
         * 2 第一次卖出
         * 3 第二次买入
         * 4 第二次卖出
         */
        for (int i = 1; i < prices.length; i++) {
            // 当天买入 = 昨天卖出 +今天买入||昨天买入今天保持
            dp[i + 1][1] = Math.max(dp[i][0] - prices[i], dp[i][1]);
            // 当天卖出 = 昨天买入+今天卖出 || 保持昨天的卖出
            dp[i + 1][2] = Math.max(dp[i][1] + prices[i],dp[i][2]);

            dp[i + 1][3] = Math.max(dp[i][2] - prices[i], dp[i][3]);
            dp[i + 1][4] = Math.max(dp[i][3] + prices[i],dp[i][4]);
        }
        return dp[prices.length][4];
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        /**
         * 0 没有任何操作
         * 1 第一次买入
         * 2 第一次卖出
         * 3 第二次买入
         * 4 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}
