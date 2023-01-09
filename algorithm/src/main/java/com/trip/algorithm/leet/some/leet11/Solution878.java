package com.trip.algorithm.leet.some.leet11;

/**
 * @author xbguo
 * @date 2022/11/22 09:42
 * @description Solution878
 * 878. 第 N 个神奇数字
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * <p>
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 * <p>
 * <p>
 * 通过次数9,076提交次数26,245
 */
public class Solution878 {
    public static void main(String[] args) {
        Solution878 solution878 = new Solution878();
       // int n = 1, a = 2, b = 3;
        // int n = 4, a = 2, b = 3;
       // int n = 1000000000, a = 40000, b = 40000;
        int n = 1000000000, a = 39999, b = 40000;

        int i = solution878.nthMagicalNumber(n, a, b);
        System.out.println(i);
        System.out.println(solution878.nthMagicalNumber2(n, a, b));
    }

    public int nthMagicalNumber(int n, int a, int b) {
        if (a % b == 0) {
            return (int) ((long) n * b % mod);
        } else if (b % a == 0) {
            return (int) ((long) n * a % mod);
        }
        long min = Math.min(a, b);
        int temp = 1;
        while ((temp * min) % a != 0 || (temp * min) % b != 0) {
            temp++;
        }
        long val = min * temp;
        long left = 1;
        long right = min * n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid / a + mid / b - mid / val;
            if (res < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) (left%mod);
    }



    int mod = 1000000007;

    public int nthMagicalNumber2(int n, int a, int b) {
        // a、b有倍数关系，可直接O(1)内返回。
        if (a % b == 0) {
            return nthMagicalNumber(n, b);
        }
        if (b % a == 0) {
            return nthMagicalNumber(n, a);
        }

        //求a和b的最公倍数p
        int p = a, i = 1;
        while (p * i % b != 0) {
            i++;
        }
        p = p * i;

        //二分查找，直到某个数之前恰好有n个神奇数字。
        long l = 1, r = (long) n * Math.min(a, b);
        while (l <= r) {
            long m = l + (r - l) / 2;
            // 求m之前的神奇数字的个数：a的倍数的数量，加上b的倍数的数量，再减去a和b的公倍数的数量
            if (m / a + m / b - m / p >= n) {
                r = --m;
            } else {
                l = ++m;
            }
        }

        return (int) (l % 1000000007);
    }

    public int nthMagicalNumber(int n, int a) {
        return (int) ((long) n * a % 1000000007);
    }
}
