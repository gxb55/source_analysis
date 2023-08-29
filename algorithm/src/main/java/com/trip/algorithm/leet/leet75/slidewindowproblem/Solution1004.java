package com.trip.algorithm.leet.leet75.slidewindowproblem;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2023年08月25日 22:20:00
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0
 */
public class Solution1004 {
    public static void main(String[] args) {

        Solution1004 solution1004 = new Solution1004();
       /* int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int  k = 2;*/

        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int i = solution1004.longestOnes1(nums, k);
        System.out.println(i);
    }

    public int longestOnes(int[] nums, int k) {
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                list1.addLast(i);
            } else {
                list0.addLast(i);
                if (list0.size() > k) {
                    Integer integer = list0.pollFirst();
                    while (!list1.isEmpty() && integer > list1.peekFirst()) {
                        list1.pollFirst();
                    }
                }
            }
            max = Math.max(max, list1.size() + list0.size());
        }
        return max;
    }

    public int longestOnes1(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {

            } else {
                t++;
                while (t > k) {
                    if (nums[left] == 0) {
                        t--;
                    }
                    left++;
                }
            }
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}
