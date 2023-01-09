package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/3/24  19:59
 * @description 238
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 通过次数175,103提交次数239,892
 */
public class Solution238 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        int[] arr ={-1,1,0,-3,3};
        int[] ints = solution238.productExceptSelf(arr);

        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                left[0] = nums[0];
            } else {
                left[i] = nums[i] * left[i - 1];
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (i == (length - 1)) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i + 1];
            }
        }

        int result[] = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == length - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }
        return result;
    }
}
