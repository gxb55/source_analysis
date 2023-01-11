package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/6/7  11:26
 * @description 875
 */
public class Solution875 {
    public static void main(String[] args) {
        Solution875 solution875 = new Solution875();
       /* int[] piles = {3, 6, 7, 11};
        int h = 8; */

        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int i = solution875.minEatingSpeed(piles, h);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        for (int i : piles) {
            sum = Math.max(i, sum);
        }
        int result = -1;
        int l = 1;
        int r = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = 0;
            for (int i : piles) {
                if (mid >= i) {
                    res++;
                } else {
                    int i1 = i % mid;
                    if (i1 == 0) {
                        res = res + (i / mid);
                    } else {
                        res = res + (i / mid) + 1;
                    }
                }
            }
            if (res > h) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        return result;
    }
}
