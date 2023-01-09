package com.trip.algorithm.leet.some.history;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/21  11:07
 * @description 202
 */
public class Solution202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        boolean happy = solution202.isHappy(2);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1) {
            char[] chars = String.valueOf(sum).toCharArray();
            sum = 0;
            for (int i = 0; i < chars.length; i++) {
                int num = chars[i] - '0';
                sum = sum + num * num;
            }
            if (!set.add(sum)) {
                return false;
            }
        }
        return true;
    }
}
