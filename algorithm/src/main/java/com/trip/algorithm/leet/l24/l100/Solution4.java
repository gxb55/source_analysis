package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {
        // int[] nums1 = {1,3}, nums2 = {2};
        int[] nums1 = {2}, nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            boolean flag = (l2) % 2 == 1;
            int l = (l2) / 2;
            if (flag) {
                return nums2[l];
            } else {
                return (nums2[l]+nums2[l-1])/2.0;
            }
        }
        if (l2 == 0) {
            boolean flag = (l1) % 2 == 1;
            int l = (l1) / 2;
            if (flag) {
                return nums1[l];
            } else {
                return (nums1[l]+nums1[l-1])/2.0;
            }
        }
        boolean flag = (l2 + l1) % 2 == 1;
        int l = (l2 + l1) / 2;
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= l&&i<(l2+l1); i++) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] < nums2[index2]) {
                    if (i >= (l-1 )) {
                        list.add(nums1[index1]);
                    }
                    index1++;
                } else {
                    if (i >= (l-1 )) {
                        list.add(nums2[index2]);
                    }
                    index2++;
                }
            } else if (index1 < nums1.length && index2 >= nums2.length) {
                if (i >= (l-1 )) {
                    list.add(nums1[index1]);
                }
                index1++;
            } else {
                if (i >= (l-1 )) {
                    list.add(nums2[index2]);
                }
                index2++;
            }
        }
        if (flag) {
            return list.get(1);
        } else {
            return (list.get(0) + list.get(1)) / 2.0;
        }
    }
}
