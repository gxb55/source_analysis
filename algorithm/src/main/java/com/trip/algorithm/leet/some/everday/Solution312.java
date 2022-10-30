package com.trip.algorithm.leet.some.everday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年08月06日 10:38:00
 * 312. 戳气球
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * 通过次数83,357提交次数119,831
 */
public class Solution312 {
    public static void main(String[] args) {

        Solution312 solution312 = new Solution312();
        int[] arr = {3, 1, 5, 8};
        // int[] arr = {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5};
        int i = solution312.maxCoins1(arr);
        System.out.println(i);
    }

    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length + 2];
        arr[0] = 1;
        arr[length + 1] = 1;
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[index] = nums[i];
            index++;
        }
        return process(arr, 0, nums.length + 1);
    }

    Map<String, Integer> map = new HashMap<>();

    private int process(int[] arr, int left, int right) {
        if (map.get(left + "_" + right) != null) {
            return map.get(left + "_" + right);
        }
        if (left == right) {
            return arr[left];
        }
        int max = 0;
        for (int i = left + 1; i < right; i++) {
            int sum = arr[left] * arr[i] * arr[right];
            sum = sum + process(arr, left, i) + process(arr, i, right);
            max = Math.max(sum, max);
        }
        map.put(left + "_" + right, max);
        return max;
    }



    /**
     * dp[l][r] =dp[l][k]+dp[k][r];
     *
     * @param nums
     * @return
     */
    public int maxCoins1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    dp[i][j] = Math.max(sum + dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }
        return dp[0][n+1];
    }

}
