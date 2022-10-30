package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月21日 22:35:00
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 通过次数227,639提交次数464,121
 */
public class Leet_494 {
    public static void main(String[] args) {
       /* int[] nums = {1, 1, 1, 1, 1};
        int target = 1; */
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        Leet_494 leet_494 = new Leet_494();
        int targetSumWays = leet_494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(target>sum){
            return 0;
        }
        if(target<Integer.valueOf("-"+sum)){
            return 0;
        }

        int[][] dp = new int[len][2 * sum + 1];
        int val = nums[0];
        dp[0][sum + val] = 1;
        dp[0][sum - val] = dp[0][sum - val]+1;
        // sum为零，sum左边是负数，sum右边是正数
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                val = nums[i];

                if ((j + val) < dp[i].length) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j + val];
                }
                if ((j - val) >= 0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - val];
                }

            }
        }

        return dp[len - 1][sum + target];
    }
}
