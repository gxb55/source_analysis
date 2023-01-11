package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/5/19  22:24
 * @description 462. 最少移动次数使数组元素相等 II
 * 462. 最少移动次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 通过次数40,796提交次数66,044
 */
public class Solution462 {
    public static void main(String[] args) {
        Solution462 solution462 = new Solution462();
        //int[] arr = {1,10,2,9};
        int[] arr = {1,2,3};
        int i = solution462.minMoves2(arr);
        System.out.println(i);
    }

    public int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int mid = len / 2;
        Arrays.sort(nums);
        if (len % 2 == 0) {
            int p1 = getResult(mid, nums);
            int p2 = getResult(mid - 1, nums);
            return Math.min(p1, p2);
        } else {
            return getResult(mid, nums);
        }
    }

    private int getResult(int mid, int[] nums) {
        int val = nums[mid];
        int res = 0;
        for (int x : nums) {
            res = res + Math.abs(x - val);
        }
        return res;
    }
}
