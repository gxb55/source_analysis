package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/4/13  16:27
 * @description 31. 下一个排列
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 */
public class Solution31 {
    public static void main(String[] args) {
        int[] nums = {2,2,0,4,3,1};
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int min = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                min = i - 1;
                break;
            }
        }
        // 当前已经是最大的序列了，则下一个序列是最小的
        if (min == -1) {
            int x = len / 2;
            for (int i = 0; i < x; i++) {
                swap(nums, i, len - i - 1);
            }
            return;
        }

        for (int i = len - 1; i > min; i--) {
            if (nums[i] > nums[min]) {
                swap(nums, i, min);
                Arrays.sort(nums, min + 1, len);
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int x = nums[i];
        nums[i] = nums[i1];
        nums[i1] = x;
    }
}
