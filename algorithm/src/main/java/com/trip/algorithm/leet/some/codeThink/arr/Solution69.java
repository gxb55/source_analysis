package com.trip.algorithm.leet.some.codeThink.arr;

/**
 * @author xbguo
 * @createTime 2022年10月31日 21:10:00
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        //int x = 4;
       // int x = 8;
        int x = 2147395599;

        int i = solution69.mySqrt(x);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long val = mid * mid;
            if (val > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (val <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            }
        }
        return (int) left;
    }
}
