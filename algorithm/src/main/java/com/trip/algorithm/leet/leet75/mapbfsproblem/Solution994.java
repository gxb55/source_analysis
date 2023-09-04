package com.trip.algorithm.leet.leet75.mapbfsproblem;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2023/9/4 17:03
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 */
public class Solution994 {
    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
       // int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
       // int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};
        int i = solution994.orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] vis = new boolean[x][y];
        for (boolean[] arr : vis) {
            Arrays.fill(arr, false);
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int i1 = grid[i][j];
                if (i1 == 2) {
                    list.addFirst(new int[]{i, j, 0});
                } else if (i1 == 0) {
                    vis[i][j] = true;
                }
            }
        }
        int max = 0;
        while (!list.isEmpty()) {
            int[] ints = list.pollLast();
            int i = ints[0];
            int j = ints[1];
            max = Math.max(max, ints[2]);
            if (vis[i][j]) {
                continue;
            }
            vis[i][j] = true;
            if ((i - 1) >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                list.addFirst(new int[]{i - 1, j, ints[2] + 1});
                grid[i - 1][j] = 2;
            }
            if ((i + 1) < x && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                list.addFirst(new int[]{i + 1, j, ints[2] + 1});
                grid[i + 1][j] = 2;
            }
            if ((j - 1) >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                list.addFirst(new int[]{i, j - 1, ints[2] + 1});
                grid[i][j - 1] = 2;
            }
            if ((j + 1) < y && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                list.addFirst(new int[]{i, j + 1, ints[2] + 1});
                grid[i][j + 1] = 2;
            }
        }
        boolean b = Arrays.stream(grid).anyMatch(t -> Arrays.stream(t).anyMatch(z -> z == 1));
        if (b) {
            return -1;
        }
        return max;
    }
}
