package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/6 11:15
 */
public class Solution2352 {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        int i = equalPairs(arr);
        System.out.println(i);
    }

    public static int equalPairs(int[][] grid) {
        Map<String,Integer> map = new HashMap<>();
        for (int[] arr : grid) {
            String collect = Arrays.stream(arr).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining("_"));
            map.put(collect,map.getOrDefault(collect,0)+1);
        }
        int x = grid.length;
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < x; i++) {
            list.clear();
            for (int j = 0; j < x; j++) {
                list.add(String.valueOf(grid[j][i]));
            }
            String collect = list.stream().collect(Collectors.joining("_"));
            if (map.containsKey(collect)) {
                count=count+map.get(collect);

            }
            list.clear();
        }
        return count;
    }
}
