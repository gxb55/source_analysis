package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.List;

public class Solution2644 {
    public static void main(String[] args) {
       int[] nums = {39,70,33}, divisors = {27,73,37,31,28,82,96,12,31,77,17,83,19,46,7,4,74,70,66,73,25,50,79};
        int v = maxDivScore(nums, divisors);
        System.out.println(v);
    }

    public static int maxDivScore(int[] nums, int[] divisors) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int t : divisors) {
            int res = 0;
            for (int i : nums) {
                if (i % t == 0) {
                    res++;
                }
            }
            list.add(res);
            max = Math.max(max, res);
        }
        int res = -1;
        for (int i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            if (v == max) {
                if (res == -1) {
                    res = divisors[i];
                }
                res = Math.min(res, divisors[i]);
            }

        }
        return res;
    }
}
