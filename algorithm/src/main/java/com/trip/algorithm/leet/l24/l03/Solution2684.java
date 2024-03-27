package com.trip.algorithm.leet.l24.l03;

public class Solution2684 {
    public static void main(String[] args) {
        Solution2684 solution2684 = new Solution2684();
        // int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        // int[][] grid = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        int[][] grid = {{187, 167, 209, 251, 152, 236, 263, 128, 135}, {267, 249, 251, 285, 73, 204, 70, 207, 74}, {189, 159, 235, 66, 84, 89, 153, 111, 189}, {120, 81, 210, 7, 2, 231, 92, 128, 218}, {193, 131, 244, 293, 284, 175, 226, 205, 245}};
        int i = solution2684.maxMoves(grid);
        System.out.println(i);
    }

    public int maxMoves(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = 0;
        int max = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                // (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1)
                if ((j - 1) >= 0 && (i - 1) >= 0 && grid[j - 1][i - 1] < grid[j][i]) {
                    dp[j][i] = Math.max(dp[j][i], dp[j - 1][i - 1] + 1);
                }
                if ((j) >= 0 && (i - 1) >= 0 && grid[j][i - 1] < grid[j][i]) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][i - 1] + 1);
                }
                if ((j + 1) < x && (i - 1) >= 0 && grid[j + 1][i - 1] < grid[j][i]) {
                    dp[j][i] = Math.max(dp[j][i], dp[j + 1][i - 1] + 1);
                }
                // 如果不是第一列，但是值是一的话说明是从上一列开始的不可以
                if (i != 1 && dp[j][i] == 1) {
                    dp[j][i] = 0;
                }
                max = Math.max(dp[j][i], max);
            }

            if (i == 1 && max == 0) {
                return 0;
            }
        }
        return max;
    }

}
