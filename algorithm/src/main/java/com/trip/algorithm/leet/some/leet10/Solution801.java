package com.trip.algorithm.leet.some.leet10;

import java.util.Arrays;

/**
 * @auther: xbguo
 * @date: 2022/10/10 15:47
 * @description: 801
 */
public class Solution801 {
    public static void main(String[] args) {
        Solution801 solution801 = new Solution801();
        // int[] nums1 = {1, 2, 3, 8}, nums2 = {5, 6, 7, 4};
        //  int[] nums1 = {3, 3, 8, 9, 10}, nums2 = {1, 7, 4, 6, 8};
      //  int[] nums1 = {0, 4, 4, 5, 9}, nums2 = {0, 1, 6, 8, 10};
       // int[] nums1 = {0,1,8,9,10}, nums2 = {0,5,5,8,9};
        int[] nums1 = {0,7,8,10,10,11,12,13,19,18}, nums2 = {4,4,5,7,11,14,15,16,17,20};

        int i = solution801.minSwap(nums1, nums2);
        System.out.println(i);
    }

    public int minSwap(int[] nums1, int[] nums2) {
        return process(1, nums1, nums2);
    }

    private int process(int i, int[] nums1, int[] nums2) {
        if (i == nums1.length) {
            return 0;
        }
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        for (; i < nums1.length; i++) {
            if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {
                int[] ints1 = Arrays.copyOf(nums1, nums1.length);
                int[] ints2 = Arrays.copyOf(nums2, nums1.length);
                int t = ints2[i];
                ints2[i] = ints1[i];
                ints1[i] = t;
                int process = process(i, ints1, ints2);
                if (process != Integer.MAX_VALUE) {
                    p1 = process + 1;
                }

                if (process != 0) {
                    int[] ints3 = Arrays.copyOf(nums1, nums1.length);
                    int[] ints4 = Arrays.copyOf(nums2, nums1.length);
                    int i1 = ints3[i - 1];
                    ints3[i - 1] = ints4[i - 1];
                    ints4[i - 1] = i1;
                    int process1 = process(i, ints3, ints4);
                    if (process1 != Integer.MAX_VALUE) {
                        p2 = process1 + 1;
                    }
                }
            }
        }
        if (p1 == p2 && p2 == Integer.MAX_VALUE) {
            return 0;
        }
        return Math.min(p1, p2);
    }
}
