package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;

public class Solution2850 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,1},{1,2,1}};
        int i = minimumMoves(grid);
        System.out.println(i);
    }

    public static int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if (v > 1) {
                    from.add(new int[]{i, j});
                } else if (v < 1) {
                    to.add(new int[]{i, j});
                }
            }
        }
        int process = process(from, to, 0, grid);
        return process;
    }

    private static int process(List<int[]> from, List<int[]> to, int index, int[][] grid) {
        if (index >= to.size()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] toArr = to.get(index);
        for (int[] fromArr : from) {
            if (grid[fromArr[0]][fromArr[1]] <= 1) {
                continue;
            }
            grid[fromArr[0]][fromArr[1]]--;
            int v = process(from, to, index + 1, grid) + Math.abs(toArr[0] - fromArr[0]) + Math.abs(toArr[1] - fromArr[1]);
            res = Math.min(res, v);
            grid[fromArr[0]][fromArr[1]]++;
        }
        return res;
    }
}
