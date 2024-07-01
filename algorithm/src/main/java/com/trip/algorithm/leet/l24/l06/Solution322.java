package com.trip.algorithm.leet.l24.l06;

import java.util.Arrays;

public class Solution322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i >= coin) {
                    if (dp[i - coin] != 0) {
                        if (dp[i] != 0) {
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        } else {
                            dp[i] = dp[i - coin] + 1;
                        }
                    }
                }
            }
        }
        if (dp[amount] == 0) {
            return -1;
        }
        return dp[amount] - 1;
    }
}
