package com.trip.algorithm.leet.some.leet2307;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/7/12 16:27
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,3]
 * 输出：7
 * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8]
 * 输出：8
 * 解释：最优子序列为 [8] ，交替和为 8 。
 * 示例 3：
 * <p>
 * 输入：nums = [6,2,1,2,4,5]
 * 输出：10
 * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-alternating-subsequence-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1911 {
    public static void main(String[] args) {
        Solution1911 solution1911 = new Solution1911();
        int[] nums = {4, 2, 5, 3};
        //  int[] nums = {5, 6, 7, 8};
        // int[] nums = {6,2,1,2,4,5};
        // int[] nums = {374, 126, 84, 237, 195, 139, 328, 353, 286, 113, 351, 167, 394, 398, 29, 118, 17, 162, 206, 138, 34, 109, 291, 368, 162, 109, 336};

        long l = solution1911.maxAlternatingSum(nums);
        System.out.println(l);

        long[][] dp = new long[2][nums.length + 1];
        Long[][] dp1 = new Long[2][nums.length + 1];

        System.out.println(dp[0][0]);
        System.out.println(dp1[0][0]);
    }

    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[2][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[0][i + 1] = Math.max(dp[0][i], nums[i] + dp[1][i]);
            dp[1][i + 1] = Math.max(dp[1][i], -nums[i] + dp[0][i]);
        }
        return Math.max(dp[0][nums.length], dp[1][nums.length]);
    }

    Map<String, Long> map = new HashMap<>();

    private Long process(int[] nums, int index, boolean flag, long total1, long total2) {
        if (index >= nums.length) {
            return Math.abs(total1 - total2);
        }
        String key = index + "_" + total1 + "_" + total2 + "_" + flag;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long p1 = process(nums, index + 1, flag, total1, total2);
        long p2 = 0;
        if (flag) {
            p2 = process(nums, index + 1, !flag, total1 + nums[index], total2);
        } else {
            p2 = process(nums, index + 1, !flag, total1, total2 + nums[index]);
        }
        long max = Math.max(p1, p2);
        map.put(key, max);
        return max;
    }
}
