package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/3/1 13:53
 */
public class Solution2373 {
    public static void main(String[] args) {
        Solution2373 solution2373 = new Solution2373();
       // int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] ints = solution2373.largestLocal(grid);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] res = new int[length - 2][length - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = getRes(grid, i, j);
            }
        }
        return res;
    }

    private int getRes(int[][] grid, int i, int j) {
        int max = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                max = Math.max(max, grid[k][l]);
            }
        }
        return max;
    }
}
