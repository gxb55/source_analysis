package com.trip.algorithm.leet.some.leet08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/18  10:35
 * @description 1224. 最大相等频率
 * 1224. 最大相等频率
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * <p>
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 通过次数9,942提交次数25,079
 */
public class Solution1224 {
    public static void main(String[] args) {
        Solution1224 solution1224 = new Solution1224();
          int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        //  int[] nums = {1,1,1,2,2,2,3,3,3,4,4,4,5};
       // int[] nums = {10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6};
        // int[] nums = {1,1,1,2,2,2};
        int i = solution1224.maxEqualFreq(nums);
        System.out.println(i);
    }

    public int maxEqualFreq(int[] nums) {
        int res = 0;
        /**
         * k 数
         * v 出现的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * k 出现的个数
         * v 这个个数的数量
         */
        Map<Integer, Integer> valMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (countMap.containsKey(num)) {
                valMap.put(countMap.get(num), valMap.get(countMap.get(num)) - 1);
            }

            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }

            valMap.put(countMap.get(num), valMap.getOrDefault(countMap.get(num), 0) + 1);


            max = Math.max(countMap.get(num), max);
            // 所有的数字都出现了一次
            if (max == 1) {
                res = Math.max(res, i + 1);
                //其中一个数字出现了n+1次，其他数字都出行了n次
            } else if ((valMap.get(max) * max + valMap.get(max - 1) * (max - 1) == (i + 1)) && valMap.get(max) == 1) {
                res = Math.max(res, i + 1);
                //所有的数字都出现了n次，其中有一个数字出现了1次
            } else if ((valMap.get(max) * max + 1) == (i + 1) && valMap.get(1) == 1) {
                res = Math.max(res, i + 1);
            }

        }
        return res;
    }

    public int maxEqualFreq1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));

            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);


            boolean ok = maxFreq == 1 ||
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }

}
