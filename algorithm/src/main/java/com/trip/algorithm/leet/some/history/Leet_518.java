package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月22日 16:56:00
 * <p>
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * 通过次数161,846提交次数236,584
 */
public class Leet_518 {
    public static void main(String[] args) {
        Leet_518 leet_518 = new Leet_518();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int change = leet_518.change(amount, coins);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        for (int i = 0; i < len; i++) {
            // 如果结果是0 肯定只有一种方法，就是都不选
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int val = coins[i];
                if (i == 0) {
                    if (j >= val) {
                        dp[i][j] = dp[i][j] + dp[i][j - val];
                    }
                } else {
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                    if (j >= val) {
                        dp[i][j] = dp[i][j] + dp[i][j - val];
                    }
                }
            }
        }
        return dp[len - 1][amount];
    }
}
