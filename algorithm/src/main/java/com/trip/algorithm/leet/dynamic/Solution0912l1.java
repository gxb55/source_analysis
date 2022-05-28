package com.trip.algorithm.leet.dynamic;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 通过次数159,879提交次数369,312
 */
public class Solution0912l1 {
    public static void main(String[] args) {
        Solution0912l1 solution0912l1 = new Solution0912l1();
        int[] arr = {6, 6, 4, 8, 4, 3, 3, 10};
        //27
        int rob = solution0912l1.rob1(arr);
        System.out.println(rob);
    }


    /**
     * 递归算法
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums, int index) {
        return 0;
    }


    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int dp[] = new int[n];
        int dp1[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp1[0] = 0;
        dp1[1] = nums[1];

        for (int i = 2; i < n - 1; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + nums[i];
        }

        for (int i = 2; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                if (dp1[j] > max) {
                    max = dp1[j];
                }
            }
            dp1[i] = max + nums[i];
        }
        int asInt = Arrays.stream(dp).max().getAsInt();
        int asInt1 = Arrays.stream(dp1).max().getAsInt();
        return Math.max(asInt, asInt1);
    }

}
