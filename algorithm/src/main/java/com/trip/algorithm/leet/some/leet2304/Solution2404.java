package com.trip.algorithm.leet.some.leet2304;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年04月13日 21:26:00
 */
public class Solution2404 {
    public static void main(String[] args) {

    }

    public int mostFrequentEven(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            if (a % 2 == 0) {
                Integer integer = map.get(a);
                if (integer == null) {
                    map.put(a, 1);
                } else {
                    map.put(a, integer + 1);
                }
                count = Math.max(map.get(a), count);
            }
        }
        if (count == 0) {
            return -1;
        }
        int v = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() == count) {
                v = Math.min(v, x.getKey());
            }
        }
        return v;
    }
}
