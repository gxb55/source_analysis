package com.trip.algorithm.countdown.dp.day0429;

/**
 * @author xbguo
 * @createTime 2023年04月29日 10:21:00
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
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 通过次数333,380提交次数755,572
 */
public class Solution213 {
    public static void main(String[] args) {
        // int[] nums = {2, 3, 2};
        //int[] nums = {1,2,3,1};
       // int[] nums = {1, 2, 1, 1};
        int[] nums = {2,2,4,3,2,5};
        int rob = Solution213.rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[1], nums[0]);
        }

        return Math.max(getRes(0, length - 1, nums), getRes(1, length, nums));
    }

    private static int getRes(int i, int length, int[] nums) {
        int count = length - i;
        if (count == 1) {
            return nums[i];
        } else if (count == 2) {
            return Math.max(nums[i + 1], nums[i]);
        }
        int[] dp = new int[length];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(nums[i + 1], nums[i]);
        int max = dp[i + 1];
        for (int j = i + 2; j < length; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j]);
            max = Math.max(max, dp[j]);
        }
        return max;
    }
}
