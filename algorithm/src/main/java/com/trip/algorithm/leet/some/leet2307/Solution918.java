package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2023/7/20 14:20
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * <p>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 */
public class Solution918 {
    public static void main(String[] args) {
        //int[] nums={1,-2,3,-2};
        //int[] nums = {5, -3, 5};
        int[] nums = {-3, -2, -3};
        int i = maxSubarraySumCircular(nums);
        System.out.println(i);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int res = nums[0];
        int curLen = nums.length;
        int len = nums.length * 2;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < curLen; i++) {
            int index = i % curLen;
            int num = nums[index];
            sum += num;
            if (dp[i - 1] >= 0) {
                dp[i] = num + dp[i - 1];
            } else {
                dp[i] = num;
            }
            res = Math.max(res, dp[i]);
        }
        int[] minDp = new int[curLen];
        minDp[0] = nums[0];
        int min = minDp[0];
        for (int i = 1; i < curLen; i++) {
            minDp[i] = Math.min(nums[i], nums[i] + minDp[i - 1]);
            min = Math.min(min, minDp[i]);
        }
        int res1 = res;
        int res2 = sum - min;
        if (res2 == 0) {
            return res1;
        }
        return Math.max(res1, res2);
    }



}
