package com.trip.algorithm.leet.some.leet2305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年05月10日 21:36:00
 */
public class Solution1015 {
    public static void main(String[] args) {
        int k = 23;
        int i = smallestRepunitDivByK(k);
        System.out.println(i);
    }

    public static int smallestRepunitDivByK(int k) {
        int cur = 1;
        int t = cur % k;
        int len = 1;
        Set<Integer> set = new HashSet<>();
        while (set.add(t)) {
            if (t == 0) {
                return len;
            }
            //  cur=cur*10+1;
            t = (t * 10 + 1) % k;
            len++;
        }
        return -1;
    }
}
