package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/26 16:29
 * 示例 1：
 * <p>
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1031 {
    public static void main(String[] args) {
        Solution1031 solution1031 = new Solution1031();
     /*   int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2; */

     /*   int[] nums = {3,8,1,3,2,1,8,9,0};
        int firstLen = 3, secondLen = 2;*/

        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen = 4, secondLen = 3;
        int i = solution1031.maxSumTwoNoOverlap1(nums, firstLen, secondLen);
        System.out.println(i);
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int sum = 0;
        int sum1 = 0;
        List<int[]> list = new ArrayList<>();
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            sum1 = sum1 + nums[i];
            if (i >= (firstLen - 1)) {
                if (i - (firstLen - 1) > 0) {
                    sum = sum - nums[i - (firstLen)];
                    list.add(new int[]{sum, i - firstLen + 1, i});
                } else {
                    list.add(new int[]{sum, 0, i});
                }
            }
            if (i >= (secondLen - 1)) {
                if (i - (secondLen - 1) > 0) {
                    sum1 = sum1 - nums[i - (secondLen)];
                    list1.add(new int[]{sum1, i - secondLen + 1, i});
                } else {
                    list1.add(new int[]{sum1, 0, i});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
            int[] cur = list1.get(i);
            for (int j = 0; j < list.size(); j++) {
                int[] ints = list.get(j);
                if (cur[1] > ints[2] || cur[2] < ints[1]) {
                    res = Math.max(res, ints[0] + cur[0]);
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @param firstLen
     * @param secondLen
     * @return
     */
    public int maxSumTwoNoOverlap1(int[] nums, int firstLen, int secondLen) {
        return Math.max(getRes(nums, firstLen, secondLen), getRes(nums, secondLen, firstLen));
    }

    private int getRes(int[] nums, int secondLen, int firstLen) {
        int lSum = 0;
        for (int i = 0; i < secondLen; i++) {
            lSum += nums[i];
        }
        int rSum = 0;
        for (int i = secondLen; i < firstLen + secondLen; i++) {
            rSum += nums[i];
        }
        int res =lSum+ rSum;
        int max1 = lSum;

        for (int i = firstLen + secondLen; i < nums.length; i++) {
            int cur = nums[i];
            rSum = rSum + cur;
            rSum = rSum - nums[i - firstLen];

            lSum = lSum + nums[i - firstLen];
            lSum = lSum - nums[i - firstLen - secondLen];

            max1 = Math.max(lSum, max1);
            res = Math.max(res, rSum + max1);
        }

        return res;
    }
}
