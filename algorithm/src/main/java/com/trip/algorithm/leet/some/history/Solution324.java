package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/5/26  17:00
 * @description 324. 摆动排序 II
 * 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 通过次数33,769提交次数87,453
 */
public class Solution324 {
    public static void main(String[] args) {
        Solution324 solution324 = new Solution324();
        // int[] nums = {1, 5, 1, 1, 6, 4};
        // int[] nums = {1,3,2,2,3,1};
       // int[] nums = {1, 1, 2, 1, 2, 2, 1};
        int[] nums = {4, 5, 5, 6};
        solution324.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        boolean flag = true;
        int right = nums.length-1;
        int left = nums.length / 2 ;
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                arr[i] = nums[left];
                left--;
            } else {
                arr[i] = nums[right];
                right--;
            }
            flag = !flag;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
