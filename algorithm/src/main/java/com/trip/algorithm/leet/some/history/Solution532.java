package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/6/16  10:41
 * @description 532. 数组中的 k-diff 数对
 * 532. 数组中的 k-diff 数对
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3：
 * <p>
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 * 通过次数37,545提交次数90,494
 */
public class Solution532 {
    public static void main(String[] args) {
        Solution532 solution532 = new Solution532();
     /*   int[] nums = {1, 2, 3, 4, 5};
        int k = 1; */

      /*  int[] nums = {1, 3, 1, 5, 4};
        int k = 0; */

        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;

       /* int[] nums = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;*/
        int pairs = solution532.findPairs(nums, k);
        System.out.println(pairs);
    }

    public int findPairs(int[] nums, int k) {

        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (k == 0) {
                if (entrySet.getValue() > 1) {
                    res++;
                }
            }else if(map.containsKey(entrySet.getKey()+k)){
                res++;
            }
        }

        return res;
    }

    private String getKey(int num, int num1) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num >= num1) {
            stringBuilder.append(num).append(num1);
        } else {
            stringBuilder.append(num1).append(num);
        }
        return stringBuilder.toString();
    }
}
