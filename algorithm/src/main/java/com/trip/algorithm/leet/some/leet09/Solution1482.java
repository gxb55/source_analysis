package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/9/7  19:32
 * @description 1482
 */
public class Solution1482 {
    public static void main(String[] args) {
        Solution1482 solution1482 = new Solution1482();
       /* int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1; */

       /* int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3; */

     /*   int[] bloomDay = {1000000000,1000000000};
        int m = 1, k = 1;*/

        int[] bloomDay = {1,10,2,9,3,8,4,7,5,6};
        int m = 4, k = 2;
        int i = solution1482.minDays(bloomDay, m, k);
        System.out.println(i);
    }

    /**
     * @param bloomDay
     * @param m
     * @param k
     * @return 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        if (length < m * k) {
            return -1;
        }
        int r = Arrays.stream(bloomDay).max().getAsInt();
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int t = 0;
            int cur = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                int openTime = bloomDay[i];
                //花开了
                if (mid >= openTime) {
                    cur++;
                } else {
                    cur = 0;
                }
                if (cur >= k) {
                    t++;
                    cur = 0;
                }
            }
            if (t >= m) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
