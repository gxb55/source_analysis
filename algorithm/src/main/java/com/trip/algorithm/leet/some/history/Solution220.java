package com.trip.algorithm.leet.some.history;

import java.util.TreeSet;

/**
 * @author xbguo
 * @date 2022/3/7  19:31
 * @description 存在重复元素 III
 * <p>
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 * 通过次数72,745提交次数252,257
 */
public class Solution220 {
    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();

        int[] arr = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        boolean b = solution220.containsNearbyAlmostDuplicate(arr, k, t);
        System.out.println(b);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        TreeSet<Long> queue = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int q = nums[i];
            if (queue.size() > k) {
                queue.remove(nums[i - k]);
            }
            int i1 = q - t;
            Long ceiling = queue.ceiling((long) i1);
            if (ceiling != null && (Math.abs(ceiling - q)) <= t) {
                return true;
            }
            queue.add(Long.valueOf(q));
        }

        return false;
    }
}
