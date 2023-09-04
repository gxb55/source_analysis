package com.trip.algorithm.leet.some.leet2309;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/9/4 18:50
 */
public class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 =new Solution322();
       /* int[] coins = {1, 2, 5};
        int amount = 11; */

       /* int[] coins = { 2};
        int amount = 3; */

        int[] coins = { 2};
        int amount = 3;
        int i = solution322.coinChange(coins,amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if ((i - coin) >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
