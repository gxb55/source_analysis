package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @createTime 2023年03月26日 16:56:00
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Solution1000 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int i = longestOnes(nums, k);
        System.out.println(i);

    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        for (; right < nums.length; right++) {
            int num = nums[right];
            if (num == 0) {
                count++;
            }
            while (left <= right && count > k) {
                int val = nums[left];
                if (val == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, (right - left + 1));
        }
        return max;
    }
}
