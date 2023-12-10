package com.trip.algorithm.leet.some.leet2312;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution503 {
    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] arr = {1, 2, 3, 4, 3};
        int[] ints = solution503.nextGreaterElements(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!list.isEmpty() && nums[list.peekLast()] < cur) {
                Integer index = list.pollLast();
                arr[index] = cur;
            }
            list.addLast(i);
        }
        if (!list.isEmpty()) {
            Integer curIndex = list.peekFirst();
            for (int i = 0; i <= curIndex; i++) {
                int cur = nums[i];
                while (!list.isEmpty() && nums[list.peekLast()] < cur) {
                    Integer index = list.pollLast();
                    arr[index] = cur;
                }
                list.addLast(i);
            }
        }
        return arr;
    }
}
