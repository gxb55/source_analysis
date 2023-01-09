package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/1/13  18:37
 * @description 递归乘法
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 * 通过次数24,767提交次数36,517
 */
public class Solution0805 {
    public static void main(String[] args) {
        Solution0805 solution0805 = new Solution0805();
        int multiply = solution0805.multiply(5, -5);
        System.out.println(multiply);
    }

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int result = getResult(Math.abs(A), Math.abs(B));
        if ((A > 0 && B < 0) || (A < 0 && B > 0)) {
            result = ~(result - 1);
        }
        return result;
    }

    private int getResult(int a, int b) {
        if (b == 0) {
            return b;
        }
        return a + getResult(a, b - 1);
    }
}
