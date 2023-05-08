package com.trip.algorithm.countdown.dp.day0429;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年04月29日 09:45:00
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * 通过次数700,231提交次数1,605,625
 *
 * 动态规划 || 贪心
 */
public class Solution55 {
    public static void main(String[] args) {
         int[] arr = {3,2,1,0,4};
        //int[] arr = {0, 2, 3};
        boolean b = canJump(arr);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        Boolean dp[] = new Boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j <= i + num && j < nums.length && dp[i]; j++) {
                dp[j] = true;
            }
        }
        return dp[nums.length - 1];
    }
}
