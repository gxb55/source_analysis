package com.trip.algorithm.leet.l24.l05;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xbguo
 * @date 2024/5/14 16:12
 */
public class Solution2244 {

    public static void main(String[] args) {
        int[] arr={2,2,3,3,2,4,4,4,4,4};
        int i = minimumRounds(arr);
        System.out.println(i);
    }

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer k : tasks) {
            int i = map.getOrDefault(k, 0) + 1;
            map.put(k, i);
        }
        int count = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                return -1;
            } else if (value == 2) {
                count = count + 1;
            } else {
                int x = value % 3;
                int y = value / 3;
                count = count + y + (x == 0 ? 0 : 1);
            }
        }

        return count;
    }
}
