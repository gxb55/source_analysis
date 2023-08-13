package com.trip.algorithm.leet.leet75.mapproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年08月13日 11:35:00
 */
public class Solution2352 {
    public static void main(String[] args) {
    //    int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int i = Solution2352.equalPairs(grid);
        System.out.println(i);
    }

    public static int equalPairs(int[][] grid) {

        Map<String, Integer> mapX = new HashMap<>();
        Map<String, Integer> mapY = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                stringBuilder.append(grid[i][j]).append("-");
            }
            String s = stringBuilder.toString();
            Integer orDefault = mapX.getOrDefault(s, 0);
            mapX.put(s, orDefault + 1);
        }

        int t = 0;
        while (t < grid[0].length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                stringBuilder.append(grid[j][t]).append("-");
            }
            String s = stringBuilder.toString();
            Integer orDefault = mapY.getOrDefault(s, 0);
            mapY.put(s, orDefault + 1);
            t++;
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : mapX.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Integer integer = mapY.get(key);
            if (integer != null) {
                res = res + value * integer;
            }
        }
        return res;
    }
}
