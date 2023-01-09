package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/26  20:55
 * @description 2256
 * 2256. 最小平均差 显示英文描述
 * 通过的用户数2599
 * 尝试过的用户数2919
 * 用户总通过次数2623
 * 用户总提交次数8478
 * 题目难度Medium
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 * <p>
 * 下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。
 * <p>
 * 请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
 * <p>
 * 注意：
 * <p>
 * 两个数的 绝对差 是两者差的绝对值。
 * n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
 * 0 个元素的平均值视为 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,3,9,5,3]
 * 输出：3
 * 解释：
 * - 下标 0 处的平均差为：|2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3 。
 * - 下标 1 处的平均差为：|(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2 。
 * - 下标 2 处的平均差为：|(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2 。
 * - 下标 3 处的平均差为：|(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0 。
 * - 下标 4 处的平均差为：|(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1 。
 * - 下标 5 处的平均差为：|(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4 。
 * 下标 3 处的平均差为最小平均差，所以返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 解释：
 * 唯一的下标是 0 ，所以我们返回 0 。
 * 下标 0 处的平均差为：|0 / 1 - 0| = |0 - 0| = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Solution2256 {
    public static void main(String[] args) {
        Solution2256 solution2256 = new Solution2256();
        //int[] nums = {2, 5, 3, 9, 5, 3};
        int[] nums = {0,0};
        int i = solution2256.minimumAverageDifference(nums);
        System.out.println(i);
    }

    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        int length = nums.length;
        long[] sumArr = new long[length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArr[i] = sum;
        }
        long res = sum;
        int index = 0;
        for (int i = 0; i < sumArr.length; i++) {
            long left = sumArr[i];
            long right = sum - sumArr[i];
            long leftVal = left / (i + 1);
            long rightVal = 0;
            if (i != length - 1) {
                rightVal = right / (length - i - 1);
            }
            long abs = Math.abs(rightVal - leftVal);
            if (abs < res) {
                index = i;
                res = abs;
            }
        }
        return index;
    }
}
