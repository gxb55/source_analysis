package com.trip.algorithm.leet.l24.l05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/5/6 18:43
 */
public class Solution741 {

    public static void main(String[] args) {
        //  int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        int[][] grid = {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
        int i = cherryPickup(grid);
        System.out.println(i);
    }

    /**
     * 0 表示这个格子是空的，所以你可以穿过它。 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。 -1 表示这个格子里有荆棘，挡着你的路。
     */
    public static int cherryPickup(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];

        //向下或向右走
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                if (val == -1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (grid[i - 1][j] == -1 && grid[i][j - 1] == -1) {
                    dp[i][j] = -1;
                } else if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        Set<int[]> set = new HashSet<>();
        int i = x - 1;
        int j = y - 1;
        int last = dp[i][j];
        if (dp[i][j] == -1) {
            return 0;
        }
        int cur = dp[i][j];
        set.add(new int[]{i, j});
        while (!(i == 0 && j == 0)) {
            if (cur > 0) {
                cur--;
            }
            if (i != 0 && j != 0) {
                if (dp[i - 1][j] == cur) {
                    set.add(new int[]{i - 1, j});
                    i--;
                } else if (dp[i][j - 1] == cur) {
                    set.add(new int[]{i, j - 1});
                    j--;
                }
            } else if (i == 0) {
                if (dp[i][j - 1] == cur) {
                    set.add(new int[]{i, j - 1});
                    j--;
                }
            } else {
                if (dp[i - 1][j] == cur) {
                    set.add(new int[]{i - 1, j});
                    i--;
                }
            }
        }
        Arrays.stream(dp).forEach(q -> Arrays.fill(q, 0));
        set.stream().forEach(q -> grid[q[0]][q[1]] = 0);
        //向上或向左走
        for (i = grid.length - 1; i >= 0; i--) {
            for (j = grid[i].length - 1; j >= 0; j--) {
                int val = grid[i][j];
                if (val == -1) {
                    continue;
                }
                if (i == grid.length - 1 && j == grid[i].length - 1) {
                    continue;
                }
                if (i == grid.length - 1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (j == grid[i].length - 1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }
        if (dp[0][0] == 0) {
            return 0;
        }
        return dp[0][0] + last;
    }
}
