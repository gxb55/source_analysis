package com.trip.algorithm.leet.l24.l05;

import java.util.HashMap;
import java.util.Map;

public class Solution1553 {
    public static void main(String[] args) {
        Solution1553 solution1553 = new Solution1553();
          int n = 10;
       // int n = 966108;
        int i = solution1553.minDays(n);
        System.out.println(i);
    }

    public int minDays(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int process = process(n, map);
        return process;
    }

    private int process(int n, Map<Integer, Integer> map) {
        if (n <= 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int t = n -(n % 3)- (2 * (n / 3));
        int min = Math.min(n % 2 + 1 + process(n / 2, map), n % 3 + 1 + process(t, map));
        map.put(n, min);
        return min;
    }
}
