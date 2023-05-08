package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年03月27日 22:32:00
 * 795. 区间子数组个数
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 */
public class Solution795 {
    public static void main(String[] args) {
       /* int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3; */

        int[] nums = {7,3,6,7,1};
        int left = 1, right = 4;

        int i = numSubarrayBoundedMax1(nums, left, right);
        System.out.println(i);
    }

    public static int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int asInt =0;
                for (int k = i; k <= j; k++) {
                    asInt=Math.max(asInt,nums[k]);
                }
                if (asInt >= left && asInt <= right) {
                    sum++;
                }else {
                    break;
                }
            }
        }
        return sum;
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (max == Integer.MIN_VALUE) {
                max = cur;
            } else {
                max = Math.max(max, cur);
            }
            if (max >= left && max <= right) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = 0;
                max = Integer.MIN_VALUE;
            }
            if (dp[i + 1] > 0) {
                sum = sum + dp[i + 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum;
    }
}
