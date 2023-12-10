package com.trip.algorithm.leet.some.leet2312;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2830 {
    public static void main(String[] args) {
        int n = 5;
        int[][] offers = {{0, 0, 1}, {0, 2, 2}, {1, 3, 2}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] offer : offers) {
            list.add(Arrays.stream(offer).boxed().collect(Collectors.toList()));
        }

        Solution2830 solution2830 = new Solution2830();
        int i = solution2830.maximizeTheProfit(n, list);
        System.out.println(i);
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < offers.size(); i++) {
            List<Integer> list = offers.get(i);
            Integer x = list.get(0);
            Integer y = list.get(1);
            Integer z = list.get(2);
            List<Integer> orDefault = map.getOrDefault(y, new ArrayList<>());
            orDefault.add(i);
            map.put(y, orDefault);
        }
        // offers[i] = [starti, endi, goldi]
        for (int i = 0; i <= n; i++) {
            dp[i] = (i - 1) < 0 ? 0 : dp[i - 1];
            List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
            for (int x : orDefault) {
                List<Integer> list = offers.get(x);
                Integer begin = list.get(0);
                Integer val = list.get(2);
                if (begin > 0) {
                    dp[i] = Math.max(dp[i], dp[begin - 1] + val);
                } else {
                    dp[i] = Math.max(dp[i], val);
                }

            }
        }
        return dp[n];
    }
}
