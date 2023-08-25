package com.trip.algorithm.leet.some.Leet2308;

/**
 * @author xbguo
 * @date 2023/8/22 10:27
 * seats = [1,0,0,0,1,0,1]
 */
public class Solution849 {
    public static void main(String[] args) {
       // int[] seats = {1,0,0,0,1,0,1};
       // int[] seats = {1,0,0,0};
        int[] seats = {1,0};
        int i = maxDistToClosest(seats);
        System.out.println(i);
    }

    public static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int max = 0;
        left[0] = seats[0] == 1 ? -1 : 1;
        for (int i = 1; i < seats.length; i++) {
            int seat = seats[i];
            if (seat == 1) {
                left[i] = -1;
            } else {
                int last = left[i - 1];
                if (last != -1) {
                    left[i] = last + 1;
                } else {
                    left[i] = 1;
                }
            }
        }
        right[len - 1] = seats[len - 1] == 1 ? -1 : 1;
        for (int i = len - 2; i >= 0; i--) {
            int seat = seats[i];
            if (seat == 1) {
                right[i] = -1;
            } else {
                int last = right[i + 1];
                if (last != -1) {
                    right[i] = last + 1;
                } else {
                    right[i] = 1;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (left[i] == -1) {
                continue;
            }
            if (i == 0) {
                max = Math.max(max, right[i]);
            } else if (i == len - 1) {
                max = Math.max(max, left[i]);
            } else {
                int t = Math.min(left[i], right[i]);
                max = Math.max(t, max);
            }
        }
        return max;
    }
}
