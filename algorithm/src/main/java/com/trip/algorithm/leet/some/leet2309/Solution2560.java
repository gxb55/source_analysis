package com.trip.algorithm.leet.some.leet2309;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/9/19 10:11
 */
public class Solution2560 {
    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        int k = 2;
        Solution2560 solution2560 = new Solution2560();
        int i = solution2560.minCapability1(nums, k);
        System.out.println(i);
    }


    public int minCapability1(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            boolean flag = true;
            for (int x : nums) {
                if (mid >= x && flag) {
                    count++;
                    flag = false;
                } else {
                    flag = true;
                }
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int k;
    int res = Integer.MAX_VALUE;
    Map<String, Integer> map = new HashMap<>();


    public int minCapability(int[] nums, int k) {
        String[][] dp = new String[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            String s0 = dp[i][0];
            String s1 = dp[i][1];
            int[] arr0 = new int[2];
            int[] arr1 = new int[2];
            if (s0 == null) {
                arr0[0] = 0;
                arr0[1] = 0;
            } else {
                String[] s = s0.split("_");
                arr0[0] = Integer.parseInt(s[0]);
                arr0[1] = Integer.parseInt(s[1]);
            }
            if (s1 == null) {
                arr1[0] = 0;
                arr1[1] = 0;
            } else {
                String[] s = s1.split("_");
                arr1[0] = Integer.parseInt(s[0]);
                arr1[1] = Integer.parseInt(s[1]);
            }
            // 当天不偷
            if (arr0[0] > arr1[0]) {

            }

        }
        return 0;
    }
}
