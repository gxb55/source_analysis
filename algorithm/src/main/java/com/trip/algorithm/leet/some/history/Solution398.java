package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author xbguo
 * @date 2022/4/25  9:11
 * @description 398
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * 通过次数22,985提交次数33,091
 */
public class Solution398 {
    public static void main(String[] args) {

    }
}

class Solution1 {
    Random random = new Random();
    Map<Integer, List<Integer>> map;

    public Solution1(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }
}