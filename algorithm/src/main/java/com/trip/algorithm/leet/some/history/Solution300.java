package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/4/21  17:16
 * @description 300
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * 通过次数497,530提交次数934,567
 */
public class Solution300 {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] nums = {0, 1, 0, 3, 2, 3};
        int i = solution300.lengthOfLIS(nums);
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = 1;
        int result = -1;
        for (int i = 1; i < length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (max == -1) {
                        max = dp[j]+1;
                    } else {
                        max = Math.max(dp[j]+1, max);
                    }
                }
            }
            if (max == -1) {
                dp[i] = 1;
            } else {
                dp[i] = max;
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
