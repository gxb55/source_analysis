package com.trip.algorithm.leet.some;

/**
 * @author xbguo
 * @createTime 2022年05月21日 21:34:00
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 通过次数69,986提交次数104,107
 */
public class Leet_1049 {
    public static void main(String[] args) {
        Leet_1049 leet_1049 = new Leet_1049();
        int[] stones = {31, 26, 33, 21, 40};
        //int[] stones = {2,7,4,1,8,1};
        int i = leet_1049.lastStoneWeightII(stones);
        System.out.println(i);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int x : stones) {
            sum = sum + x;
        }
        int q = sum / 2;
        boolean[][] dp = new boolean[stones.length][q + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int val = stones[i];
                if (i == 0 && j == val) {
                    dp[i][j] = true;
                } else if (i > 0) {
                    // 当前不选的情况
                    dp[i][j] = dp[i - 1][j];
                    // 当前符合选的条件
                    if ((j - val) > 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                    } else if (((j - val) == 0)) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        int left = 0;
        for (int i = q; i >= 0; i--) {
            if (dp[stones.length - 1][i]) {
                left = i;
                break;
            }
        }
        int right = sum - left;
        return Math.abs(right - left);
    }
}
