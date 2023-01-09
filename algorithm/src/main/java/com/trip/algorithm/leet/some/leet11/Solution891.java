package com.trip.algorithm.leet.some.leet11;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/11/18 09:35
 * @description Solution891
 * 891. 子序列宽度之和
 * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
 * <p>
 * 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：6
 * 解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
 * 相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
 * 宽度之和是 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [2]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 通过次数6,144提交次数14,666
 * 22927522
 * 预期结果：
 * 857876214
 */
public class Solution891 {
    public static void main(String[] args) {
        Solution891 solution891 = new Solution891();
        // int[] arr = {2, 1, 3};
        //    int[] arr = {2};
        int[] arr = {5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13};
        int i = solution891.sumSubseqWidths(arr);
        System.out.println(i);
        System.out.println(Math.pow(2,3));
    }

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int val = nums[j] - nums[i];
                res = res + (int)(Math.pow(2,(j-i-1))*val);
                res = res % mod;
            }
        }
        return res;
    }

    //int mod = 1000000007;
    int mod = 1000000007;
}
