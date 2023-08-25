package com.trip.algorithm.leet.some.Leet2308;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/23 16:52
 */
public class Solution1782 {
    public static void main(String[] args) {

    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : edges) {
            int i = arr[0];
            int j = arr[1];
            int val1 = map.getOrDefault(i, 0) + 1;
            map.put(i, val1);
            int val2 = map.getOrDefault(j, 0) + 1;
            map.put(j, val2);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).collect(Collectors.toList());

        return null;
    }
}
