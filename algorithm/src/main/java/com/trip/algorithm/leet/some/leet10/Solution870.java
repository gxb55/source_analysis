package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/8 19:15
 * @description: 870
 */
public class Solution870 {
    public static void main(String[] args) {
        Solution870 solution870 = new Solution870();
      //  int[] nums1 = {2, 7, 11, 15}, nums2 = {1, 10, 4, 11};
        int[] nums1 = {12,24,8,32}, nums2 = {13,25,32,11};
        int[] ints = solution870.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for (int x : nums1) {
            list.add(x);
        }
        int length = nums1.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = getIndexRes(list, nums2[i]);
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (res[i] == -1) {
                res[i] = list.get(index);
                index++;
            }
        }
        return res;
    }

    private int getIndexRes(List<Integer> nums1, int val) {
        if (val > nums1.get(nums1.size() - 1)) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int index = -1;
        int right = nums1.size() - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midVal = nums1.get(mid);
            if (midVal > val) {
                res = midVal;
                index = mid;
            }
            if (val >= midVal) {
                left = mid + 1;
            } else {
              right=mid-1;
            }
        }
        if (res != -1) {
            nums1.remove(index);
        }
        return res;
    }
}
