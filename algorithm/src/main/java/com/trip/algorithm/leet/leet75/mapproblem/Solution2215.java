package com.trip.algorithm.leet.leet75.mapproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年08月13日 11:05:00
 */
public class Solution2215 {
    public static void main(String[] args) {
        Solution2215 solution2215 = new Solution2215();
       // int[] nums1 = {1, 2, 3}, nums2 = {2, 4, 6};
        int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
        List<List<Integer>> difference = solution2215.findDifference(nums1, nums2);
        for (List<Integer> t : difference) {
            System.out.println(t);
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int x : nums2) {
            if (!set1.contains(x)&&!list1.contains(x)) {
                list1.add(x);
            }
        }
        for (int x : nums1) {
            if (!set2.contains(x)&&!list2.contains(x)) {
                list2.add(x);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(list2);
        res.add(list1);
        return res;
    }
}
