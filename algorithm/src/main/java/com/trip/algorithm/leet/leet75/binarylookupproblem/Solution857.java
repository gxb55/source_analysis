package com.trip.algorithm.leet.leet75.binarylookupproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年09月02日 15:34:00
 */
public class Solution857 {
    public static void main(String[] args) {
        Solution857 solution857 = new Solution857();
        /*int[] piles = {3, 6, 7, 11};
        int h = 8;*/
       /* int[] piles = {312884470};
        int h = 312884469;*/

       /* int[] piles = {312884470};
        int h = 968709470;*/
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;

        int i = solution857.minEatingSpeed(piles, h);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            long mid = left + (right - left) / 2;
            boolean flag = getRes(piles, mid, h);
            if (flag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean getRes(int[] piles, long mid, int h) {
        long res = 0;
        for (int t : piles) {
            int i = (int) (t / mid);
            int i1 = (int) (t % mid);
            res = res + (i==0?1:i);
            if (i1 != 0) {
                res = res + 1;
            }
        }
        return res <= h;
    }
}
