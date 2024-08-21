package com.trip.algorithm.leet.l24.l08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/8/16 10:08
 */
public class Solution3148 {
    public static void main(String[] args) {
        int[][] grid = {
                {9, 5, 7, 3},
                {8, 9, 6, 1},
                {6, 7, 14, 3},
                {2, 5, 3, 1}
        };
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : grid) {
            list.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        int i = maxScore1(list);
        System.out.println(i);
    }

    public static int maxScore(List<List<Integer>> grid) {
        int[][] dp = new int[grid.size()][grid.get(0).size()];
        int len = grid.size();
        dp[0][0] = 0;

        int[][] arr = new int[dp.length][dp[0].length];
        arr[0][0] = grid.get(0).get(0);
        for (int i = 1; i < len; i++) {
            Integer cur = grid.get(i).get(0);
            Integer last = grid.get(i - 1).get(0);
            if (cur > last) {

                dp[i][0] = dp[i - 1][0] + cur - last;
            } else {
                dp[i][0] = dp[i - 1][0];
                grid.get(i).set(0, last);
            }
        }
        List<Integer> list = grid.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            Integer last = list.get(i - 1);
            if (cur > last) {
                dp[0][i] = dp[0][i - 1] + cur - last;
            } else {
                dp[0][i] = dp[0][i - 1];
                list.set(i, last);
            }
        }

        for (int i = 1; i < grid.size(); i++) {
            for (int j = 1; j < grid.get(i).size(); j++) {
                int cur = grid.get(i).get(j);
                int r = Math.max(0, cur - grid.get(i - 1).get(j));
                int l = Math.max(0, cur - grid.get(i).get(j - 1));
                dp[i][j] = Math.max(dp[i - 1][j] + r, dp[i][j - 1] + l);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static int maxScore1(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int minTemp = min;
                if (i > 0) {
                    minTemp = Math.min(minTemp, dp[i - 1][j]);
                }
                if (j > 0) {
                    minTemp = Math.min(minTemp, dp[i][j - 1]);
                }
                ans = Math.max(ans, grid.get(i).get(j) - minTemp);
                dp[i][j]=Math.min(grid.get(i).get(j),minTemp);
            }
        }
        return ans;
    }
}
