package com.trip.algorithm.leet.some.leet2304;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年04月09日 08:04:00
 */
public class Solution827 {
    public static void main(String[] args) {
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int max = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = grid[i][j];
                if (cur == 1 && dp[i][j] == 0) {
                    int t = i * n + j + 1;
                    int dfs = dfs(grid, i, j, dp, t);
                    max = Math.max(dfs, max);
                    map.put(t, dfs);
                }
            }
        }
        if (max == 0) {
            return 1;
        }
        if (max == grid.length * grid[0].length) {
            return max;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = grid[i][j];
                Set<Integer> set = new HashSet<>();
                if (cur == 0) {
                    int p1 = 0;
                    if ((i - 1) >= 0) {
                        int t = dp[i - 1][j];
                        Integer integer = map.get(t);
                        if (integer != null && !set.contains(dp[i - 1][j])) {
                            set.add(dp[i - 1][j]);
                            p1 = p1 + integer;
                        }
                    }
                    if ((i + 1) < grid.length) {
                        int t = dp[i + 1][j];
                        Integer integer = map.get(t);
                        if (integer != null && !set.contains(dp[i + 1][j])) {
                            set.add(dp[i + 1][j]);
                            p1 = p1 + integer;
                        }
                    }
                    if ((j - 1) >= 0) {
                        int t = dp[i][j - 1];
                        Integer integer = map.get(t);
                        if (integer != null && !set.contains(dp[i][j - 1])) {
                            set.add(dp[i][j - 1]);
                            p1 = p1 + integer;
                        }
                    }
                    if ((j + 1) < grid[0].length) {
                        int t = dp[i][j + 1];
                        Integer integer = map.get(t);
                        if (integer != null && !set.contains(dp[i][j + 1])) {
                            set.add(dp[i][j + 1]);
                            p1 = p1 + integer;
                        }
                    }
                    max = Math.max(max, p1 + 1);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp, int t) {
        if (i < 0 || i > grid.length) {
            return 0;
        }
        if (j < 0 || j > grid[0].length) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return 0;
        }
        if (grid[i][j] == 1) {
            int p = 0;
            dp[i][j] = t;
            if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                p = p + dfs(grid, i - 1, j, dp, t);
            }
            if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
                p = p + dfs(grid, i + 1, j, dp, t);
            }
            if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
                p = p + dfs(grid, i, j - 1, dp, t);
            }
            if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
                p = p + dfs(grid, i, j + 1, dp, t);
            }
            return p + 1;
        }
        return 0;
    }
}
