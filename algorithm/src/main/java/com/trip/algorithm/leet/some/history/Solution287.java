package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/11  21:41
 * @description 287
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class Solution287 {
    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        //int[] nums = {5, 1, 5, 4, 2};
        int[] nums = {3,1,3,4,2};
        int duplicate = solution287.findDuplicate(nums);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int leftVal = mid;
            for (int i : nums) {
                if (i <= mid) {
                    leftVal--;
                }
            }
            if (leftVal < 0) {
                right = mid ;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}