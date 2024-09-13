package com.trip.algorithm.leet.l24.l09;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/9/12 14:23
 */
public class Solution2576 {
    public static void main(String[] args) {
         // int[] arr={3,5,2,4};
          int[] arr={57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92};
        // int[] arr = {9, 2, 5, 4};
      //  int[] arr = {42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40};
        int i = maxNumOfMarkedIndices(arr);
        System.out.println(i);
    }

    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length / 2;
        int r=j;
        int count = 0;
        for (; i < r && j < nums.length; i++, j++) {
            while (j < nums.length&&nums[i] * 2 > nums[j] ) {
                j++;
            }
            if (j < nums.length) {
                count += 2;
            }
        }
        return count;
    }
}
