package com.trip.algorithm.codethink.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xbguo
 * @date: 2022/11/7 19:41
 */
public class Solution454 {
    public static void main(String[] args) {
        Solution454 solution454 = new Solution454();
      //  int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};

        int[] nums1 = {-1,-1}, nums2 = {-1,1}, nums3 = {-1,1}, nums4 = {1,-1};
        int i = solution454.fourSumCount(nums1,nums2,nums3,nums4);
        System.out.println(i);
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int i1 = nums1[i] + nums2[j];
                if (map.containsKey(i1)) {
                    map.put(i1, map.get(i1) + 1);
                } else {
                    map.put(i1, 1);
                }
            }
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int i1 = nums3[i] + nums4[j];
                if (map1.containsKey(i1)) {
                    map1.put(i1, map1.get(i1) + 1);
                } else {
                    map1.put(i1, 1);
                }
            }
        }
        int x = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int i = 0 - key;
            if (map1.containsKey(i)) {
                x = x + entry.getValue() * map1.get(i);
            }
        }
        return x;
    }
}
