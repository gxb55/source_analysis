package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/20 09:54
 */
public class Solution1595 {
    public static void main(String[] args) {
        // int[][] cost = {{1, 3, 5}, {4, 1, 1}, {1, 5, 3}};
        // int[][] cost = {{2, 5, 1}, {3, 4, 7}, {8, 1, 2}, {6, 2, 4}, {3, 8, 8}};
        //int[][] cost =  {{15, 96}, {36, 2}};
        int[][] cost = {
                {93, 56, 92},
                {53, 44, 18},
                {86, 44, 69},
                {54, 60, 30}
        };
        int i = connectTwoGroups(convert(cost));
        System.out.println(i);
    }

    private static List<List<Integer>> convert(int[][] cost) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : cost) {
            list.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        return list;
    }

    public static int connectTwoGroups(List<List<Integer>> cost) {
        for (int i = 0; i < cost.size(); i++) {
            System.out.println(cost.get(i));
        }
        System.out.println();
        List<int[]> list = new ArrayList<>();
        int x = cost.size();
        int y = cost.get(0).size();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            // map.put("A" + i, y);
        }
        for (int i = 0; i < y; i++) {
            //map.put("B" + i, x);
        }
        for (int i = 0; i < cost.size(); i++) {
            for (int j = 0; j < cost.get(i).size(); j++) {
                list.add(new int[]{i, j, cost.get(i).get(j)});
            }
        }
        List<int[]> r = new ArrayList<>();
        list.sort((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            int q = ints[0];
            int w = ints[1];
            Integer integer1 = map.get("B" + w);
            Integer integer2 = map.get("A" + q);
            if (integer1 == null || integer2 == null) {
                r.add(ints);

                map.put("B" + w, integer1 == null ? 1 : integer1 + 1);
                map.put("A" + q, integer2 == null ? 1 : integer2 + 1);
                cost.get(q).set(w, -1);
            }
        }
        int sum1 = r.stream().map(z -> z[2]).filter(z -> z > 0).mapToInt(z -> z).sum();
        for (int i = 0; i < cost.size(); i++) {
            System.out.println(cost.get(i));
        }
        return sum1;
    }
}
