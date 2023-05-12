package com.trip.algorithm.countdown.dp.day0430;

/**
 * @author xbguo
 * @createTime 2023年04月30日 16:42:00
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * 通过次数118,637提交次数170,630
 */
public class Solution413 {
    public static void main(String[] args) {
        Solution413 solution413 = new Solution413();
        int[] nums = {1,2,3,4};
        int i = solution413.numberOfArithmeticSlices(nums);
        System.out.println(i);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int[] dp = new int[length];
        for (int i = 2; i < length; i++) {
            if (dp[i - 1] == 0) {
                if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                    dp[i] = 3;
                }
            } else {
                if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 2; i < length - 1; i++) {
            if (dp[i] > 0 && dp[i + 1] == 0) {
                sum += getRes(dp[i]);
            }
        }
        sum = sum + getRes(dp[length - 1]);
        return sum;
    }

    private int getRes(int i) {
        if (i == 0) {
            return 0;
        }
        int count = 0;
        int first = 3;
        while (first <= i) {
            count += (i - first) + 1;
            first++;
        }
        return count;
    }
}
