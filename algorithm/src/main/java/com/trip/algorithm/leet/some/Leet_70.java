package com.trip.algorithm.leet.some;

/**
 * @author xbguo
 * @createTime 2022年05月21日 17:31:00
 * <p>
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 * 通过次数832,639提交次数1,550,894
 */
public class Leet_70 {
    public static void main(String[] args) {
        Leet_70 leet_70 = new Leet_70();
        int i = leet_70.climbStairs(3);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        // f(x)=f(x-1)+f(x-2);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
