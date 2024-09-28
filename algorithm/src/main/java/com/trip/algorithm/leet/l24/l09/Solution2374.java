package com.trip.algorithm.leet.l24.l09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2374 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 0, 7, 7, 5};
        //  int[] arr = {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int i = edgeScore(arr);
        System.out.println(i);
    }

    public static int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {

            // i->j
            int val = edges[i];
            map.put(val, map.getOrDefault(val, 0L) + i);
        }
        List<Map.Entry<Integer, Long>> collect = map.entrySet().stream().sorted((x, y) -> {
            if (x.getValue().equals(y.getValue())) {
                return (x.getKey() - y.getKey()) >= 0 ? 1 : -1;
            } else {
                return (y.getValue() - x.getValue()) >= 0 ? 1 : -1;
            }
        }).collect(Collectors.toList());

        return collect.get(0).getKey();
    }

}
