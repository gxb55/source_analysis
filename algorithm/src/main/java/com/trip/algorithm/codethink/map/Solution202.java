package com.trip.algorithm.codethink.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther: xbguo
 * @date: 2022/11/7 19:14
 */
public class Solution202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        int x = 19;
        boolean happy = solution202.isHappy(x);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int x = 0;
            for (int i = 0; i < chars.length; i++) {
                int i1 = chars[i] - '0';
                x = x + (i1 * i1);
            }
            n = x;
        }
    }
}
