package com.trip.algorithm.leet.some.Leet2308;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/24 19:01
 */
public class Solution1267 {
    public static void main(String[] args) {
     //   int[][] grid = {{1, 0}, {0, 1}};
      //  int[][] grid = {{1,0},{1,1}};
        int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        Solution1267 solution1267 = new Solution1267();
        int i = solution1267.countServers(grid);
        System.out.println(i);
    }

    public int countServers(int[][] grid) {
        Map<Integer, Set<int[]>> mapX = new HashMap<>();
        Map<Integer, Set<int[]>> mapY = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    int[] arr =new int[]{i,j};
                    Set<int[]> orDefault = mapX.getOrDefault(i, new HashSet<>());
                    orDefault.add(arr);
                    mapX.put(i, orDefault);

                    Set<int[]> orDefault1 = mapY.getOrDefault(j, new HashSet<>());
                    orDefault1.add(arr);
                    mapY.put(j, orDefault1);
                }
            }
        }
        List<int[]> collect = mapY.values().stream().filter(x -> x.size() > 1).flatMap(x -> x.stream()).collect(Collectors.toList());
        List<int[]> collect1 = mapX.values().stream().filter(x -> x.size() > 1).flatMap(x -> x.stream()).collect(Collectors.toList());
        collect1.addAll(collect);
        List<int[]> collect2 = collect1.stream().distinct().collect(Collectors.toList());

        return collect2.size();

    }
}
