package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年08月14日 19:47:00
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
 * 通过次数272,186提交次数620,056
 */
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
       // int[] arr = {2, 3, 2};
        //int[] arr = {1,2,3,1};
        int[] arr = {1,2,3};
        int rob = solution213.rob1(arr);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];
        // i当前天数 j=0表示当前积累的钱，j=1代表当前的钱数是否用了第一天的钱
        dp[0][0] = nums[0];
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            boolean flag = false;
            int action = nums[i];
            if ((i - 2) >= 0) {
                action = nums[i] + dp[i - 2][0];
                if (dp[i - 2][1] == 1) {
                    flag = true;
                }
            }
            int noAction = dp[i - 1][0];
            if (noAction > action) {
                dp[i][0] = noAction;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = action;
                dp[i][1] = flag ? 1 : 0;
            }
        }
        int sum = dp[len - 1][0];
        if (dp[len - 1][1] == 1) {
            sum = sum - nums[0];
        }
        return sum;
    }

    public int rob1(int[] nums) {
        String s="";
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i <= length - 2; i++) {
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
        int cur = dp[length - 2];
        dp = new int[length];
        dp[1] = nums[1];
        for (int i = 2; i <= length - 1; i++) {
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
        return Math.max(cur, dp[length - 1]);
    }
}
