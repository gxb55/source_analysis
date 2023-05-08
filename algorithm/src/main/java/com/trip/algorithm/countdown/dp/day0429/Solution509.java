package com.trip.algorithm.countdown.dp.day0429;

/**
 * @author xbguo
 * @createTime 2023年04月29日 08:21:00
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 简单题，直接dp即可，动态规划中逻辑简单
 */
public class Solution509 {
    public static void main(String[] args) {
        int n = 3;
        int fib = fib(n);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int x = 0;
        int y = 1;
        int index = 2;
        int t;
        while (index <= n) {
            t = x + y;
            x = y;
            y = t;
            index++;
        }
        return y;
    }
}
