package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/2/22 19:42
 */
public class Solution1326 {
    public static void main(String[] args) {
     /*   int n = 5;
      //  int[] ranges = {3, 4, 1, 1, 0, 0};
        int[] ranges = {0, 0, 0 , 0, 0};
        */
        int n = 7;
        int[] ranges = {1, 2, 1, 0, 2, 1, 0, 1};


        int i = Solution1326.minTaps(n, ranges);
        System.out.println(i);
    }

    public static int minTaps(int n, int[] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            int range = ranges[i];
            if (range == 0) {
                continue;
            }
            int left = Math.max(i - range, 0);
            int right = Math.min(i + range, n);
            list.add(new int[]{left, right});
        }
        List<int[]> collect = list.stream().sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        if (collect.size() == 0) {
            return -1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if (dp[ints[0]] == Integer.MAX_VALUE) {
                return -1;
            }
            for (int j = ints[0]; j <= ints[1] && j <= collect.size(); j++) {
                dp[j] = Math.min(dp[j], dp[ints[0]] + 1);

            }
        }
        return dp[n];
    }
}
