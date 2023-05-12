package com.trip.algorithm.countdown.dp.day0430;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年04月30日 17:14:00
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 示例 2：
 * <p>
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 通过次数23,652提交次数43,095
 */
public class Solution446 {
    public static void main(String[] args) {
        Solution446 solution446 = new Solution446();
        //int[] arr = {2, 4, 6, 8, 10};
        //int[] arr = {7, 7, 7, 7, 7};
        int[] arr = {0, 2000000000, -294967296};
        int i = solution446.numberOfArithmeticSlices(arr);
        System.out.println(i);
    }

    public int numberOfArithmeticSlices1(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        Map<Integer, Long>[] dp = new Map[length];
        for (int i = 0; i < length; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int val = nums[i] - nums[j];
                // 到j的时候相差val的数列有多长
                Long orDefault = dp[j].getOrDefault(val, 0L);
                ans += orDefault;
                dp[i].put(val, orDefault + 1 + dp[i].getOrDefault(val, 0L));
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        List<Long> list = new ArrayList<>();
        process(nums, 0, list);
        return res.size();
    }

    List<List<Long>> res = new ArrayList<>();

    private void process(int[] nums, int index, List<Long> list) {
        if (index == nums.length) {
            if (list.size() < 3) {
                return;
            }
            Long val = list.get(1) - list.get(0);
            for (int i = 2; i < list.size(); i++) {
                if (val != (list.get(i) - list.get(i - 1))) {
                    return;
                }
            }
            res.add(list);
            return;
        }
        process(nums, index + 1, list);
        List<Long> integers = new ArrayList<>(list);
        integers.add((long) nums[index]);
        process(nums, index + 1, integers);
    }

}
