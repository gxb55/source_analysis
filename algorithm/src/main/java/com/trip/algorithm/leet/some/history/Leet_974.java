package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @version 1.0.0
 * @ClassName Leet_974.java
 * @createTime 2022年03月26日 16:23:00
 * <p>
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 * <p>
 * 输入: nums = [5], k = 9
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 * 通过次数43,366提交次数92,271
 */
public class Leet_974 {
    public static void main(String[] args) {
        Leet_974 leet_974 = new Leet_974();
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int i = leet_974.subarraysDivByK(arr, k);
        System.out.println(i);
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (Integer integer : nums) {
            sum = sum + integer;
            int t = (sum % k + k) % k;
            if (map.containsKey(t)) {
                res = res + map.get(t);
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}
