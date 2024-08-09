package com.trip.algorithm.leet.l24.l08;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/8/8 16:54
 */
public class Solution3131 {

    public static void main(String[] args) {

    }

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0]-nums1[0];
    }
}
