package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月21日 17:50:00
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 通过次数267,771提交次数517,395
 */
public class Leet_416 {
    public static void main(String[] args) {
        Leet_416 leet_416 = new Leet_416();
        int[] nums = {1, 5, 11, 5};
        boolean b = leet_416.canPartition1(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int x = sum / 2;
        if (x * 2 != sum) {
            return false;
        }
        int cur = 0;
        int index = 0;
        return process(nums, index, cur, x);
    }


    private boolean process(int[] nums, int index, int cur, int res) {
        if (cur == res) {
            return true;
        }
        if (cur > res) {
            return false;
        }
        if (index >= nums.length) {
            return false;
        }
        boolean p1 = process(nums, index + 1, cur + nums[index], res);
        boolean p2 = process(nums, index + 1, cur, res);
        return p1 || p2;
    }


    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int x = sum / 2;
        if (x * 2 != sum) {
            return false;
        }
        int len = nums.length;
        boolean[][] dp = new boolean[len][x+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int num = nums[i];
                if (i == 0 && j == num) {
                    dp[i][j] = true;
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                    if (j > num) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                    }
                }
            }
        }

        return dp[len - 1][x ];
    }
}
