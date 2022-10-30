package com.trip.algorithm.leet.some.everday;

/**
 * @author xbguo
 * @createTime 2022年06月25日 21:50:00
 * <p>
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 * <p>
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 * <p>
 * <p>
 * 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/
 * <p>
 * 通过次数28,388提交次数36,601
 */
public class Solution_offer_2_91 {
    public static void main(String[] args) {
        Solution_offer_2_91 solutionOffer291 = new Solution_offer_2_91();
         int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
       // int[][] costs = {{20, 18, 4}, {9, 9, 10}};
        int i = solutionOffer291.minCost(costs);
        System.out.println(i);
    }

    public int minCost(int[][] costs) {
        int res;
        int len = costs.length;
        int[][] dp = new int[len][3];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = costs[i];
            } else {
                dp[i][1] = costs[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
                dp[i][0] = costs[i][0] + Math.min(dp[i - 1][2], dp[i - 1][1]);
                dp[i][2] = costs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
            }
        }
        res = Math.min(dp[len - 1][0], dp[len - 1][1]);
        res = Math.min(res, dp[len - 1][2]);
        return res;
    }
}
