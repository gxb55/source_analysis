package com.trip.algorithm.leet.some.history;

import java.util.HashMap;

/**
 * @author xbguo
 * @date 2022/3/7  18:56
 * @description 存在重复元素
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * 通过次数165,584提交次数372,444
 */
public class Solution219 {

    public static void main(String[] args) {
        Solution219 solution219 = new Solution219();
        int[] arr = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean b = solution219.containsNearbyDuplicate(arr, k);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (map.containsKey(t) && (i - map.get(t)) <= k) {
                return true;
            }
            map.put(t, i);
        }
        return false;
    }
}
