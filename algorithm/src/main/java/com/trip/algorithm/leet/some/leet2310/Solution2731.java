package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/10/10 16:24
 */
public class Solution2731 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 2};
        String s = "RLL";
        int d = 3;

        /*int[] nums = {1, 0};
        String s = "RL";
        int d = 2;*/
        int i = sumDistance(nums, s, d);
        System.out.println(i);
    }

    public static int sumDistance(int[] nums, String s, int d) {
        int MOD = 1000000007;
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += 1L * (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            res %= MOD;
        }
        return (int) res;
    }
}
