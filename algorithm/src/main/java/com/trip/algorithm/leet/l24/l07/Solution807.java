package com.trip.algorithm.leet.l24.l07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution807 {
    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int i = maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            Integer i1 = Arrays.stream(grid[i]).boxed().max((x, y) -> x - y).get();
            xMap.put(i, i1);
        }
        int y = grid[0].length;
        for (int i = 0; i < y; i++) {
            int v = 0;
            for (int j = 0; j < grid.length; j++) {
                v = Math.max(grid[j][i], v);
            }
            yMap.put(i, v);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(xMap.get(i), yMap.get(j));
                count = count + min - grid[i][j];
            }
        }
        return count;
    }
}
