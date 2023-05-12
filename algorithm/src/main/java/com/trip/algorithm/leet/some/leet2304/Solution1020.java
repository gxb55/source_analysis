package com.trip.algorithm.leet.some.leet2304;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年04月09日 08:22:00
 */
public class Solution1020 {
    public static void main(String[] args) {
        Solution1020 solution1020 = new Solution1020();
        /*int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };*/

        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        int i = solution1020.numEnclaves(grid);
        System.out.println(i);
    }

    public int numEnclaves(int[][] grid) {
        if (grid[0].length == 1) {
            return 0;
        }
        int index = 10;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int val = color(grid, i, j, index);
                    map1.put(index, val);
                    index++;
                }
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map.get(entry.getKey()) == null) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

    Map<Integer, Boolean> map = new HashMap<>();

    private int color(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0) {
            map.put(index, true);
            return 0;
        }
        if (grid[i][j] <= 0 || grid[i][j] == index) {
            return 0;
        }
        grid[i][j] = index;
        return color(grid, i + 1, j, index) +
                color(grid, i - 1, j, index) +
                color(grid, i, j + 1, index) +
                color(grid, i, j - 1, index) + 1;
    }
}
