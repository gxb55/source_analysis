package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/2/28 09:40
 */
public class Solution2363 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : items1) {
            int i = arr[0];
            int j = arr[1];
            if (map.containsKey(i)) {
                int i1 = map.get(i) + j;
                map.put(i, i1);
            } else {
                map.put(i, j);
            }
        }
        for (int[] arr : items2) {
            int i = arr[0];
            int j = arr[1];
            if (map.containsKey(i)) {
                int i1 = map.get(i) + j;
                map.put(i, i1);
            } else {
                map.put(i, j);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        map.entrySet().forEach(x -> {
            List<Integer> list1 = new ArrayList<>();
            list1.add(x.getKey());
            list1.add(x.getValue());
            list.add(list1);
        });
        list.sort((x,y)->x.get(0)-y.get(0));
        return list;
    }
}
