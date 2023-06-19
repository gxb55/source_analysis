package com.trip.algorithm.leet.some.leet2306;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/6/19 14:32
 */
public class Solution1254 {
    public static void main(String[] args) {
        Solution1254 solution1254 = new Solution1254();
   //     int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
      //  int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] grid = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        int i = solution1254.closedIsland(grid);
        for (int[] a:grid){
            System.out.println(Arrays.toString(a));
        }
        System.out.println(i);
    }

    /**
     * 0 （土地）和 1 （水）
     * 岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int index = 5;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    index++;
                    Boolean bfs = bfs(grid, index, i, j);
                    if (bfs) {
                        System.out.println(index+":"+bfs);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private Boolean bfs(int[][] grid, int val, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] != 0) {
            return true;
        }
        grid[x][y] = val;
        return bfs(grid, val, x + 1, y) &
                bfs(grid, val, x - 1, y) &
                bfs(grid, val, x, y + 1) &
                bfs(grid, val, x, y - 1);
    }
}
