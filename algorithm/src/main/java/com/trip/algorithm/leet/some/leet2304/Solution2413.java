package com.trip.algorithm.leet.some.leet2304;

/**
 * @author xbguo
 * @date 2023/4/21 14:51
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 *
 * 输入：n = 6
 * 输出：6
 */
public class Solution2413 {
    public static void main(String[] args) {
        int n=1;
        int i = smallestEvenMultiple(n);
        System.out.println(i);
    }

    public static int smallestEvenMultiple(int n) {
        int min = 2;
        int max = n;
        if (max < min) {
            int t = max;
            max = min;
            min = t;
        }
        int t ;
        while (min > 0) {
            t = max % min;
            max = min;
            min = t;
        }
        return n * 2 / max;

    }
}
