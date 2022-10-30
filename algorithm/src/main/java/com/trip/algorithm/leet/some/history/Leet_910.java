package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月30日 17:09:00
 * 910. 最小差值 II
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * <p>
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * <p>
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 104
 * 0 <= k <= 104
 * 通过次数8,251提交次数24,759
 */
public class Leet_910 {
    public static void main(String[] args) {
        Leet_910 leet_910 = new Leet_910();
        int[] arr = Util.getArr("[1,3,6]");
        int i = leet_910.smallestRangeII(arr, 3);
        System.out.println(i);
    }

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            ans = Math.min(max - min, ans);
        }
        return ans;
    }

    private Integer getResult(int[][] dp, Integer min, int index, List<Integer> list) {
        if (index == dp.length) {
            int max = list.get(0);
            int max1 = list.get(0);
            for (Integer integer : list) {
                max = Math.max(integer, max);
                max1 = Math.min(integer, max1);
            }
            int cur = max - max1;
            min = Math.min(cur, min);
            return min;
        }
        list.add(dp[index][0]);
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        p1 = getResult(dp, min, index + 1, list);
        list.remove(Integer.valueOf(dp[index][0]));
        list.add(dp[index][1]);
        p2 = getResult(dp, min, index + 1, list);
        list.remove(Integer.valueOf(dp[index][1]));
        return Math.min(p1, p2);
    }
}
