package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2924 {
    public static void main(String[] args) {

    }

    public int findChampion(int n, int[][] edges) {
        // 谁比我强
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        // 从 a 队到 b 队的有向边意味着 a 队比 b 队 强
        for (int[] arr : edges) {
            int from = arr[0];
            int to = arr[1];
            map.get(to).add(from);
        }
        List<Integer> collect = map.entrySet().stream().filter(x -> x.getValue().size() == 0).map(x -> x.getKey()).collect(Collectors.toList());
        if (collect.size() == 1) {
            return collect.get(0);
        }
        return -1;
    }
}
