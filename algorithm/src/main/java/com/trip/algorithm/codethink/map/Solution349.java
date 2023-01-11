package com.trip.algorithm.codethink.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther: xbguo
 * @date: 2022/11/7 19:06
 * @description: TODO
 */
public class Solution349 {
    public static void main(String[] args) {
        Solution349 solution349 = new Solution349();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] intersection = solution349.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
            }
        }
        int size = list.size();
        int[] arr = new int[size];
        int index = 0;
        for (int i : list) {
            arr[index] = i;
            index++;
        }
        return arr;
    }
}
