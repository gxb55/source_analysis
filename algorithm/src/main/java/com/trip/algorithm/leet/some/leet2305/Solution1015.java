package com.trip.algorithm.leet.some.leet2305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年05月10日 21:36:00
 */

public class Solution1015 {
    public static void main(String[] args) {
        int k = 3;
        // k = 23;
        int i = smallestRepunitDivByK(k);
        System.out.println(i);
    }

    public static int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int cnt = 1, x = 1 % k;
        while (x > 0) {
            System.out.println(10 * x + 1);
            x = (10 * x + 1) % k;
            if (set.contains(x)) {
                return -1;
            }
            set.add(x);
            cnt ++;
        }
        return cnt;
    }
}
