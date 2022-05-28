package com.trip.algorithm.leet.some;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年05月21日 17:23:00
 * <p>
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 104
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * 通过次数61,798提交次数88,506
 */
public class Leet_961 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        Leet_961 leet_961 = new Leet_961();
        int i = leet_961.repeatedNTimes(arr);
        System.out.println(i);
    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer integer = map.get(i);
            if (integer == null) {
                map.put(i, 1);
            } else {
                map.put(i, integer + 1);
            }
        }
        int x = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= x) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
