package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @auther: xbguo
 * @date: 2022/10/25 09:43
 * @description: Solution934
 */
public class Solution934 {
    public static void main(String[] args) {
        Solution934 s = new Solution934();
       // int[][] grid = {{0,1},{1,0}};
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
       // int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        int i = s.shortestBridge1(grid);
        System.out.println(i);

    }

    public int shortestBridge(int[][] grid) {
        boolean[][] dp = new boolean[grid.length][grid.length];
        int len = grid.length;
        List<int[]> list = new ArrayList<>();
        t:
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    process(grid, i, j, dp, list);
                    break t;
                }
            }
        }
        int min = len;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1 && !dp[i][j]) {
                    int finalI = i;
                    int finalJ = j;
                    int val = list.stream().map(x -> Math.abs(x[0] - finalI) + Math.abs(x[1] - finalJ)).mapToInt(x -> Integer.valueOf(x-1)).min().getAsInt();
                    min = Math.min(min, val);
                }
            }
        }
        return min;
    }

    private void process(int[][] grid, int i, int j, boolean[][] dp, List<int[]> list) {
        if (i >= grid.length || i < 0 || j >= grid.length || j < 0 || grid[i][j] == 0) {
            return;
        }
        if (dp[i][j]) {
            return;
        }
        dp[i][j] = true;
        list.add(new int[]{i, j});
        process(grid, i - 1, j, dp, list);
        process(grid, i + 1, j, dp, list);
        process(grid, i, j + 1, dp, list);
        process(grid, i, j - 1, dp, list);
    }

    public int shortestBridge1(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<int[]>();
        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

}
