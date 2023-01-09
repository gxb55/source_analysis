package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/22 11:04
 * @description 1753
 */
public class Solution1753 {
    public static void main(String[] args) {
        Solution1753 solution1753 = new Solution1753();
        // int a = 2, b = 4, c = 6;
        int a = 4, b = 4, c = 6;
        int i = solution1753.maximumScore(a, b, c);
        System.out.println(i);
    }

    int res = -1;

    public int maximumScore(int a, int b, int c) {
        int x = 0;
        process(a, b, c, x);
        return res;
    }

    private int process(int a, int b, int c, int x) {
        if ((a == 0 && b == 0) || (a == 0 && c == 0) || (c == 0 && b == 0)) {
            res = Math.max(res, x);
            return 0;
        }
        if ((a - 1) >= 0 && (b - 1) >= 0) {
            process(--a, --b, c, ++x);
        }
        int i = x;
        if ((c - 1) >= 0 && (b - 1) >= 0) {
            process(a, --b, --c, ++x);
        }
        int i1 = x;
        if ((a - 1) >= 0 && (c - 1) >= 0) {
            process(--a, b, --c, ++x);
        }
        int i2 = x;
        return Math.max(Math.max(i, i1), i2);
    }
}
