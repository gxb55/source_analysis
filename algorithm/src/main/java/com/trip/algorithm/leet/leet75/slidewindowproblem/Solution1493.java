package com.trip.algorithm.leet.leet75.slidewindowproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/25 15:09
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class Solution1493 {
    public static void main(String[] args) {
        Solution1493 solution1493 = new Solution1493();
       //   int[] nums = {1,1,0,1};
       //   int[] nums = {0,1,1,1,1,1,1,0,1};
       // int[] nums = {1, 1, 1};
        int[] nums = {0, 0, 0};
        int i = solution1493.longestSubarray1(nums);
        System.out.println(i);
    }

    public int longestSubarray(int[] nums) {
        int length = nums.length;
        boolean b = Arrays.stream(nums).allMatch(x -> x == 1);
        if (b) {
            return length - 1;
        }
        int[] left = new int[length];
        left[0] = nums[0] == 0 ? 0 : 1;
        int[] right = new int[length];
        right[length - 1] = nums[length - 1] == 0 ? 0 : 1;
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num == 0) {
                left[i] = 0;
                list.add(i);
            } else {
                left[i] = left[i - 1] + 1;
            }
            max = Math.max(max, left[i]);
        }
        for (int i = length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num == 0) {
                right[i] = 0;
            } else {
                right[i] = right[i + 1] + 1;
            }
            max = Math.max(max, right[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer > 0 && integer < length - 1) {
                int cur = left[integer - 1] + right[integer + 1];
                max = Math.max(max, cur);
            }
        }
        return max;
    }


    public int longestSubarray1(int[] nums) {

        int max = 0;
        int lastIndex = -1;
        int left = 0;
        int length = nums.length;
        boolean b = Arrays.stream(nums).allMatch(x -> x == 1);
        if (b) {
            return length - 1;
        }
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == 0) {
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    max = Math.max(i - left-1, max);
                    left = lastIndex+1;
                    lastIndex = i;
                }
            }
        }
        max = Math.max(length - left-1, max);
        return max;
    }
}
