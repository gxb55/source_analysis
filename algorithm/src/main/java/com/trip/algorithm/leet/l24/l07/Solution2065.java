package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2065 {
    public static void main(String[] args) {
        Solution2065 solution2065 = new Solution2065();
        int[] values = {0, 32, 10, 43};
        int[][] edges = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime = 49;
        int i = solution2065.maximalPathQuality(values, edges, maxTime);
        System.out.println(i);
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            List<int[]> orDefault = map.getOrDefault(x, new ArrayList<>());
            orDefault.add(new int[]{y, z});
            map.put(x, orDefault);

            List<int[]> orDefault1 = map.getOrDefault(y, new ArrayList<>());
            orDefault1.add(new int[]{x, z});
            map.put(y, orDefault1);
        }
        List<Integer> set = new ArrayList<>();
        set.add(0);
        process(map, values, 0, maxTime, 0, values[0], set);
        return res;
    }

    int res = 0;

    private void process(Map<Integer, List<int[]>> map, int[] values, int index, int maxTime, int curTime, int curVal, List<Integer> set) {
        if (curTime > maxTime) {
            return;
        }
        if (index == 0) {
            res = Math.max(res, curVal);
        }
        List<int[]> ints = map.get(index);
        if (ints == null) {
            return;
        }
        for (int[] arr : ints) {
            int y = arr[0];
            int z = arr[1];
            boolean flag = set.contains(y);
            set.add(y);
            process(map, values, y, maxTime, curTime + z, !flag ? curVal + values[y] : curVal, set);
            set.remove(Integer.valueOf(y));
        }
    }
}
