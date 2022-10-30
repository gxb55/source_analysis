package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年04月16日 17:51:00
 * 479. 最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 * <p>
 * 输入： n = 1
 * 输出： 9
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 8
 * 通过次数14,483提交次数24,156
 */
public class Leet_479 {
    public static void main(String[] args) {
        Leet_479 leet_479 = new Leet_479();
        int i = leet_479.largestPalindrome(2);
        System.out.println(i);
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            // 左半部分
            long left = i;
            for (long j = left; j > 0; j /= 10) {
                left = left * 10 + j % 10;
            }
            // 整体回文
            for (long j = max; j *j >=left; --j) {
                if (left % j == 0) {
                    return (int) (left % 1337);
                }
            }
        }
        return 0;
    }

    public int largestPalindrome1(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
