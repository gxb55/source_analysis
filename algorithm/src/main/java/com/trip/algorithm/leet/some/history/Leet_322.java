package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月22日 16:07:00
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * 通过次数443,680提交次数972,814
 */
public class Leet_322 {
    public static void main(String[] args) {
        Leet_322 leet_322 = new Leet_322();
       /* int[] coins = {1, 2, 5};
        int amount = 11;*/

       /* int[] coins = {2};
        int amount = 3;*/

        int[] coins = {1, 2};
        int amount = 2;
        int i = leet_322.coinChange(coins, amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        /**
         * dp[x]
         * x:钱数
         * dp[x] 代表最少硬币数量
         */
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 可以选硬币了
                if (i >= coin) {
                    // 这个位置首次放
                    if (dp[i] == 0) {
                        //依赖前一个位置是有效的
                        if (dp[i - coin] != 0 || (i - coin) == 0) {
                            dp[i] = dp[i - coin] + 1;
                        }
                    } else {
                        if (dp[i - coin] != 0 || (i - coin) == 0) {
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]!=0){
                System.out.println("下标：" + i + ",val:" + dp[i]);
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}