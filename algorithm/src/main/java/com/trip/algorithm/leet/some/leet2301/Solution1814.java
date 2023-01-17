package com.trip.algorithm.leet.some.leet2301;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/17 11:07
 * @description 1814
 * 1814. 统计一个数组中好对子的数目
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 通过次数10,899提交次数24,518
 */
public class Solution1814 {
    public static void main(String[] args) {
        Solution1814 solution1814 = new Solution1814();
        int[] nums = {0, 11, 1, 97};
        int i = solution1814.countNicePairs(nums);
        System.out.println(i);
    }

    /**
     * 109 + 7 取
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String s = new StringBuffer().append(num).reverse().toString();
            while (s.startsWith("0") && s.length() > 1) {
                s = s.substring(1);
            }

            int numR = Integer.valueOf(s);
            int val = num - numR;
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value >= 2) {
                for (int i = 1; i < value; i++) {
                    res = (res % mod) + (i % mod);
                    res = res % mod;
                }
            }
        }
        return res;
    }
}
