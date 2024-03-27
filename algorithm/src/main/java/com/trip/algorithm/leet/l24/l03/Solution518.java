package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/3/25 14:52
 */
public class Solution518 {
    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        int amount = 5;
        int[] coins = {1, 2, 5};

     /*   int amount = 500;
        int[] coins = {3,5,7,8,9,10,11};*/
        String s="-1";
        System.out.println(s.substring(1,s.length()));

        int change = solution518.change3(amount, coins);
        System.out.println(change);
    }
    public int change3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if ((i - coin) == 0) {
                    dp[i] = dp[i] + 1;
                } else if ((i - coin) < 0) {

                } else {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        List<Integer> list = new ArrayList<>();
        process(amount, 0, coins, list);
       /*  Arrays.sort(coins);
       List<List<Integer>> collect = resList.stream().distinct().collect(Collectors.toList());
        collect.forEach(x -> System.out.println(x));*/
        return resList.size();
    }

    List<List<Integer>> resList = new ArrayList<>();

    private void process(int amount, int index, int[] coins, List<Integer> list) {
        if (amount == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            int val = coins[i];
            if ((amount - val) >= 0) {
                list.add(val);
                process(amount - val, i, coins, list);
                list.remove(Integer.valueOf(val));
            }
        }
    }
}
