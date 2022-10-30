package com.trip.algorithm.leet.some.history;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * <p>
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * <p>
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集
 *
 * @author Administrator
 */
public class Leet_2044 {
    public static void main(String[] args) {
        int nums[] = {2, 2, 2};
        Leet_2044 leet_2044 = new Leet_2044();
        int i = leet_2044.countMaxOrSubsets1(nums);
        System.out.println(i);
    }

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (Integer integer : nums) {
            max = max | integer;
        }

        int cur = 0;
        return getResult(nums, 0, max, cur);
    }

    private int getResult(int[] nums, int index, int max, int cur) {
        if (index == nums.length) {
            if (cur == max) {
                return 1;
            }
            return 0;
        }
        return getResult(nums, index + 1, max, cur | nums[index]) + getResult(nums, index + 1, max, cur);
    }

    public int countMaxOrSubsets1(int[] nums) {
        // 数组中所有元素或运算肯定是最大值
        // 每个元素可选可不选，枚举所有状态，计算是不是等于最大值
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max |= num;
        }

        int ans = 0;
        int len = 1 << n;
        for (int mask = 0; mask < len; mask++) {
            int or = 0;
            for (int i = 0; i < n; i++) {
                int x = mask >> i;
                int y = x & 1;
                if (y == 1) {
                    or |= nums[i];
                }
            }
            if (or == max) {
                ans++;
            }
        }

        return ans;
    }


}
