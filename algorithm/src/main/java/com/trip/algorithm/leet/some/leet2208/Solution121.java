package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年08月13日 12:26:00
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * 通过次数883,471提交次数1,520,123
 */
public class Solution121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = solution121.maxProfit(arr);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[j][i] = prices[i];
                    }
                } else {
                    if (j == 0) {
                        dp[j][i] = Math.min(prices[i], dp[j][i-1]);
                    } else {
                        dp[j][i] = prices[i] - dp[j - 1][i - 1];
                        max = Math.max(dp[j][i], max);
                    }
                }
            }
        }

        return max;
    }
}
