package com.trip.algorithm.leet.some.leet2305;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/5/10 19:20
 */
public class Solution1015 {
    public static void main(String[] args) {
        int k = 3;
        // k = 23;
        int i = smallestRepunitDivByK(k);
        System.out.println(i);
    }

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0) {
            return -1;
        }
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
