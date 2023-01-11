package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月28日 20:05:00
 * 813. 最大平均值和的分组
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 * <p>
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * 通过次数21,007提交次数34,978
 */
public class Solution813 {
    public static void main(String[] args) {
        Solution813 solution813 = new Solution813();
       /* int[] nums = {9, 1, 2, 3, 9};
        int k = 3;*/
        int[] nums = {1,2,3,4,5,6,7};
        int k = 4;
        double v = solution813.largestSumOfAverages(nums, k);
        System.out.println(v);
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[] sum = new double[len + 1];
        sum[1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        // dp[i][j] i长度的数据分割为j份
        // dp[i][j] = dp[i-1][j-1] dp[i-2][j-1] 分割分数-1，数组长度可以一直改变，从这些里面求一个最大值出来即可
        double[][] dp = new double[len + 1][k + 1];
        // 数组长度
        for (int i = 1; i < len + 1; i++) {
            // 分割的段数
            for (int j = 1; j <= Math.min(k, i); j++) {
                // 分割为一段
                if (j == 1) {
                    dp[i][j] = sum[i] / i;
                } else {
                    for (int w = 1; w <= i; w++) {
                        dp[i][j] = Math.max(dp[i][j], dp[w - 1][j - 1] + ((sum[i] - sum[w-1]) / (i - w+1)));
                    }
                }
            }
        }
        return dp[len][k];
    }
}
