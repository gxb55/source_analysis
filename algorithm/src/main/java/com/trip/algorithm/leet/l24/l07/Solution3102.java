package com.trip.algorithm.leet.l24.l07;

import java.util.TreeMap;

public class Solution3102 {
    public static void main(String[] args) {

    }

    /**
     * @param points
     * @return
     */
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> maxTreeMap = new TreeMap<>();
        TreeMap<Integer, Integer> minTreeMap = new TreeMap<>();
        for (int[] arr : points) {
            int x = arr[0];
            int y = arr[1];
            maxTreeMap.merge(x + y, 1, Integer::sum);
            minTreeMap.merge(x - y, 1, Integer::sum);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] arr : points) {
            int x = arr[0];
            int y = arr[1];
            Integer merge = maxTreeMap.merge(x + y, -1, Integer::sum);
            if (merge == 0) {
                maxTreeMap.remove(x + y);
            }
            merge = minTreeMap.merge(x - y, -1, Integer::sum);
            if (merge == 0) {
                minTreeMap.remove(x - y);
            }
            ans = Math.min(ans, Math.max(Math.abs(maxTreeMap.firstKey() - maxTreeMap.lastKey()), Math.abs(minTreeMap.firstKey() - minTreeMap.lastKey()))
            );
            maxTreeMap.merge(x + y, 1, Integer::sum);
            minTreeMap.merge(x - y, 1, Integer::sum);
        }
        return ans;
    }
}
