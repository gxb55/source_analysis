package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/6/15  16:05
 * @description 719
 * 719. 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 * 通过次数21,367提交次数48,926
 */
public class Solution719 {
    public static void main(String[] args) {
        Solution719 solution719 = new Solution719();
        int[] nums = {1, 3, 1};
        int k = 1;
        int i = solution719.smallestDistancePair(nums, k);
        System.out.println(i);
    }

    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        List<Integer> collect = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        return collect.get(k-1);
    }
}
