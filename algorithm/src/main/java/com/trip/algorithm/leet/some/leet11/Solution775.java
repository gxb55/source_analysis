package com.trip.algorithm.leet.some.leet11;

/**
 * @author xbguo
 * @date 2022/11/16 10:32
 * <p>
 * 775. 全局倒置与局部倒置
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * <p>
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * <p>
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * <p>
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] < n
 * nums 中的所有整数 互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 * 通过次数13,345提交次数28,315
 */
public class Solution775 {
    public static void main(String[] args) {
        Solution775 solution775 = new Solution775();
        // int[] nums = {1, 0, 2};
        int[] nums = {0, 1};
        boolean idealPermutation = solution775.isIdealPermutation1(nums);
        System.out.println(idealPermutation);
    }

    public boolean isIdealPermutation(int[] nums) {
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            if (i < nums.length - 1 && nums[i] > nums[i + 1]) {
                count1++;
            }
        }
        return count1 == count;
    }

    public boolean isIdealPermutation1(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (max > nums[i]) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
