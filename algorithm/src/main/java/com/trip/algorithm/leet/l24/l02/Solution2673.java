package com.trip.algorithm.leet.l24.l02;

import java.util.HashMap;
import java.util.Map;

public class Solution2673 {
    public static void main(String[] args) {
        Solution2673 solution2673 = new Solution2673();
        int n = 7;
        int[] cost = {1, 5, 2, 2, 3, 3, 1};
        int i = solution2673.minIncrements(n, cost);
        System.out.println(i);
    }



    public int minIncrements(int n, int[] cost) {
        process(cost, 1, 0);
        Map<Integer, Integer> curMap = new HashMap<>();
        map.entrySet().forEach(x -> {
            int i = (x.getKey()) / 2;
            curMap.put(i, max - x.getValue());
        });
        int res = 0;
        System.out.println(curMap);
        while (curMap.size() > 1) {
            Map<Integer, int[]> tempMap = new HashMap<>();
            curMap.entrySet().forEach(x -> {
                int i = (x.getKey()) / 2;
                int[] ints = tempMap.get(i);
                if (ints == null) {
                    tempMap.put(i, new int[]{x.getValue(), 0});
                } else {
                    ints[1] = x.getValue();
                    tempMap.put(i, ints);
                }
            });
            curMap.clear();
            for (Map.Entry<Integer, int[]> x : tempMap.entrySet()) {
                Integer key = x.getKey();
                int[] value = x.getValue();
                int min = Math.min(value[0], value[1]);
                res += Math.abs(value[0] - value[1]);
                curMap.put(key, min);
            }
        }
        return res;
    }
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();

    private void process(int[] cost, int index, int sum) {
        if (index > cost.length) {
            max = Math.max(sum, max);
            map.put(index, sum);
            return;
        }
        int i = cost[index - 1];
        process(cost, index * 2, sum + i);
        process(cost, index * 2 + 1, sum + i);
    }
}
