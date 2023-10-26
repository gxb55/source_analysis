package com.trip.algorithm.leet.some.leet2310;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/10/26 10:16
 */
public class Solution2520 {
    public static void main(String[] args) {
        int num = 121;
        int i = Solution2520.countDigits(num);
        System.out.println(i);
    }

    public static int countDigits(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        for (Character character : chars) {
            Integer v = character - '0';
            int i = map.getOrDefault(v, 0) + 1;
            map.put(v, i);
            set.add(v);
        }
        int sum = 0;
        for (int x : set) {
            if (num % x == 0) {
                sum = sum + map.get(x);
            }
        }
        return sum;
    }
}
