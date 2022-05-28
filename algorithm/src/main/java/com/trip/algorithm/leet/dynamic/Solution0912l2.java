package com.trip.algorithm.leet.dynamic;

/**
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
 * 通过次数376,371提交次数733,114
 */
public class Solution0912l2 {
    public static void main(String[] args) {
        Solution0912l2 solution0912l2 = new Solution0912l2();
        int[] arr = {6, 6, 4, 8, 4, 3, 3, 10};
        int rob = solution0912l2.rob(arr);
        System.out.println(rob);
        int rob1 = solution0912l2.rob1(arr);
        System.out.println(rob1);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = dp[0] > dp[1] ? dp[0] : dp[1];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = getMax(dp, i - 2) + nums[i];
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    private int getMax(int[] dp, int i) {
        int max = 0;
        for (int j = 0; j <= i; j++) {
            if (dp[j] > max) {
                max = dp[j];
            }
        }
        return max;
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        return process(nums, 0);
    }

    /**
     * 6, 6, 4, 8, 4, 3, 3, 10
     * @param nums
     * @param index
     * @return
     */
    public int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int p1 = process(nums, index + 2) + nums[index];
        int p2 = process(nums, index + 1);
        return Math.max(p1, p2);
    }


}
