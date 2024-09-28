package com.trip.algorithm.leet.l24.l09;

import java.util.*;

public class Solution997 {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        // 有信任的人
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : trust) {
            // i 信任 j
            int i = arr[0];
            int j = arr[1];
            set.add(i);
            List<Integer> orDefault = map.getOrDefault(j, new ArrayList<>());
            orDefault.add(i);
            map.put(j, orDefault);
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            List<Integer> list = map.get(i);
            if (list == null || list.size() != n - 1) {
                continue;
            }
            return i;
        }
        return -1;
    }
}
