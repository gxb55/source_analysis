package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年03月26日 19:52:00
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 通过次数49,306提交次数85,214
 */
public class Solution1248 {
    public static void main(String[] args) {
       /* int[] nums = {1, 1, 2, 1, 1};
        int k = 3; */

        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int i = numberOfSubarrays(nums, k);
        System.out.println(i);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        boolean b = Arrays.stream(nums).filter(x -> x == 1).count() < k;
        if (b) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int lastIndex = -1;
        for (; right < nums.length; right++) {
            int num = nums[right];
            if (num == 1) {
                count++;
            }
            while (count > k && left <= right) {
                if (nums[left] == 1) {
                    count--;
                }
                left++;
            }
            if (count == k) {
                if (left <= lastIndex && lastIndex != -1) {
                    res = res + lastIndex - left + 1;
                } else {
                    for (int i = left; i <= right; i++) {
                        if (nums[i] == 1) {
                            lastIndex = i;
                            break;
                        }
                    }
                    res = res + lastIndex - left + 1;
                }
            }
        }
        return res;
    }
}
