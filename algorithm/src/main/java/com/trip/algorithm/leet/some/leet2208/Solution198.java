package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年08月14日 19:23:00
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 通过次数609,599提交次数1,135,541
 */
public class Solution198 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        // int[] arr = {1, 2, 3, 1};
        // int[] arr = {2,7,9,3,1};
        int[] arr = {1, 2};
        int rob = solution198.rob(arr);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            //行动,获得当前的钱
            int action = nums[i];
            if ((i - 2) >= 0) {
                //之前如果存在则可以获取到
                action = action + dp[i - 2];
            }
            //不行动
            int noAction = dp[i - 1];
            //当天获得的钱是 在行动 和 不行动中间取最大的；
            dp[i] = Math.max(action, noAction);
        }
        return dp[length - 1];
    }
}
