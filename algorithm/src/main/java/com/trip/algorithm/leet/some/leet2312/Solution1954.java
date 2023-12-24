package com.trip.algorithm.leet.some.leet2312;

public class Solution1954 {
    public static void main(String[] args) {
        // long neededApples = 1;
        //  long neededApples = 13;
        long neededApples = 9;
        //long neededApples = 1000000000;
        long l = Solution1954.minimumPerimeter(neededApples);
        System.out.println(l);
    }

    /**
     * 输入：neededApples = 1000000000
     * 输出：5040
     */
    public static long minimumPerimeter(long neededApples) {
        long res = 0;
        long last = 0;
        long cur = 0;
        long t = 0;
        while (cur < neededApples) {
            t++;
            cur = (t + t) * 4 + ((t + ((2 * t) - 1)) * (2 * t - t)) * 4 -4*t + last;
            last = cur;
        }
        res = t * 2 * 4;
        return res;
    }
}
