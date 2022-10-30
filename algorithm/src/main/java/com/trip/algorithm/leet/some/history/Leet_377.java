package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月22日 09:33:00
 * 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * <p>
 * 输入：nums = [9], target = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * <p>
 * <p>
 * val
 * dp[i][j] =                   dp[i-1][j] +dp[i-1][j-val] +dp[i-1][j-2*val] +dp[i-1][j-3*val] .....
 * dp[i][j+val]=dp[i-1][j+val] +dp[i-1][j] +dp[i-1][j-val] +dp[i-1][j-2*val] +dp[i-1][j-3*val].....
 * <p>
 * dp[i][j+val]=dp[i-1][j+val] + dp[i][j];
 */
public class Leet_377 {
    public static void main(String[] args) {
        Leet_377 leet_377 = new Leet_377();
        int[] nums = {1, 2, 3};
        int target = 4;
        int i = leet_377.combinationSum41(nums, target);
        System.out.println(i);
    }

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int[][] dp = new int[len][sum + 1];
        int val = nums[0];
        dp[0][val] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                val = nums[i];
                if (i == 0) {
                    if ((j - val) > 0) {
                        dp[i][j] = dp[i][j - val];
                    }
                } else {
                    int temp = j - val;
                    if (temp > 0) {
                        dp[i][j] = dp[i][j - val] + dp[i - 1][j];
                    } else if (temp < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
        }

        return dp[len - 1][target];
    }

    /**
     * @param nums
     * @param target
     * @return 零钱种类不同，没种零钱可以使用n多次
     * 假如目标是 4，零钱是 1 2 3
     * 1 1 2 ，2 1 1，是两种解法，这叫排列
     */
    public int combinationSum41(int[] nums, int target) {
        /**
         * dp[x]
         * x 代表当前凑成组合的值；
         * 假如 零钱有 1 2 3
         * 那如何得到x =（x-1）+（x-2）+（x-3）
         * dp[x] 得到和为x的时候组合数是多少
         */
        int[] dp = new int[target + 1];
        //0 枚零钱，凑出来 0的总价，只有一种解法，就是不选
        dp[0] = 1;
        //0 枚零钱的讨论过了，这里讨论1枚零钱的时候
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public int combinationSum42(int[] nums, int t) {
        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
        int len = t;
        int[][] f = new int[len + 1][t + 1];
        f[0][0] = 1;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= t; j++) {
                for (int u : nums) {
                    if (j >= u) {
                        f[i][j] += f[i - 1][j - u];
                    }
                }
            }
            ans += f[i][t];
        }
        return ans;
    }


}
