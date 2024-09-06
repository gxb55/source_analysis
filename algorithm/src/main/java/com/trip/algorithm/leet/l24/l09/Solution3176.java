package com.trip.algorithm.leet.l24.l09;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/9/6 09:50
 */
public class Solution3176 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        int i = maximumLength(nums, k);
        System.out.println(i);
    }

    public static int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length ][501];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            // 当前这个数字，不占用别的自己就贡献1
            dp[i][0] = 1;
            // 在符合的k的范围内
            for (int j = 0; j <= k; j++) {
                // 比他小的数字
                for (int l = 0; l < i; l++) {
                    // 从比他小的数字且范围符合要求，切能增加长度且再次符合要求
                    int add = nums[i] == nums[l] ? 0 : 1;
                    // 还有数字可以用 && 从那个数字调过来的是合法的
                    if ((j - add) >= 0 && dp[l][j - add] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[l][j - add] + 1);
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;

    }
}
