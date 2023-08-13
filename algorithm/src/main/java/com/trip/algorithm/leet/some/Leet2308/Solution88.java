package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年08月13日 10:39:00
 */
public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1, 0, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            int v2 = nums2[j];
            int v1 = nums1[i];
            if (v2 < v1) {
                setIndex(i, v2, nums1);
                j++;
                if(j>nums2.length){
                    break;
                }
            }
            if (i == nums1.length - 1 && j < nums2.length) {
                int t = j;
                int len = nums2.length - 1;
                int len1 = nums1.length - 1;
                while (len >= t) {
                    nums1[len1] = nums2[len];
                    len1--;
                    len--;
                }
            }
        }
    }

    private void setIndex(int index, int val, int[] arr) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = val;
    }
}
