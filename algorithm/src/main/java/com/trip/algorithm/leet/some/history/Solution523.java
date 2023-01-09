package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/3/30  20:55
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 */
public class Solution523 {
    public static void main(String[] args) {
        /*int[] nums = {23,2,6,4,7};
        int k = 6;*/
        /*int[] nums = {5,0,0,0};
        int k =3;*/
        int[] nums = {2, 4, 3};
        int k = 6;
        Solution523 solution523 = new Solution523();
        boolean b = solution523.checkSubarraySum(nums, k);
        System.out.println(b);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (Arrays.stream(nums).allMatch(x -> x == 0) && nums.length >= 2) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        map.put(0, list1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            sum += val;

            int t = sum % k;
            if (t == 0 && sum != 0 && i > 1) {
                return true;
            }
            List<Integer> list = map.get(t);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(t, list);
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            sum += val;
            int i1 = sum % k;
            List<Integer> list = map.get(i1);
            if (list != null && list.get(0) + 1 < i) {
                return true;
            }
        }
        return false;
    }
}
