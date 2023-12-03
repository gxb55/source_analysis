package com.trip.algorithm.leet.some.leet2311;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/11/27 19:11
 */
public class Solution496 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        Solution496 solution496 = new Solution496();
        int[] ints = solution496.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[list2.size()];

        for (int i = list2.size() - 1; i >= 0; i--) {
            int cur = list2.get(i);
            while (!deque.isEmpty() && cur >= list2.get(deque.peekLast())) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = deque.peekLast();
            }
            deque.addLast(i);
        }
        int[] res1 = new int[list1.size()];

        for (int i = 0; i < list1.size(); i++) {
            int cur = list1.get(i);
            int index = list2.indexOf(cur);
            int re = res[index];
            if (re == -1) {
                res1[i] = -1;
            } else {
                res1[i] = list2.get(re);
            }
        }
        return res1;
    }
}
