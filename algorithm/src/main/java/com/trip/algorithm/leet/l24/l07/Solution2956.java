package com.trip.algorithm.leet.l24.l07;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/7/16 19:55
 * @description TODO
 */
public class Solution2956 {

    public static void main(String[] args) {

    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int[] res = new int[2];
        res[0] = (int) Arrays.stream(nums1).filter(x -> set2.contains(x)).count();
        res[1] = (int) Arrays.stream(nums2).filter(x -> set1.contains(x)).count();
        return res;
    }
}
