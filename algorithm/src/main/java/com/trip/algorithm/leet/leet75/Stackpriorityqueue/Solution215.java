package com.trip.algorithm.leet.leet75.Stackpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年08月05日 16:35:00
 */
public class Solution215 {
    public static void main(String[] args) {
       /* int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2; */
       /* int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4; */

        int[] arr = {6,5};
        int k = 1;
        int kthLargest = findKthLargest1(arr, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int x : nums) {
            queue.add(x);
        }
        while (k > 1) {
            k--;
            queue.poll();
        }
        return queue.poll();
    }

    public static int findKthLargest1(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        return process(nums, 0, nums.length - 1, k);
    }

    private static int process(int[] nums, int left, int right, int k) {
        int val = nums[left];
        int curLeft = left ;
        int curRight = right;
        while (curRight > curLeft) {
            // 从大到小，先从小的获取
            while (curRight > curLeft && nums[curRight] <= val) {
                curRight--;
            }
            while (curRight > curLeft && nums[curLeft] >= val) {
                curLeft++;
            }
            if (curRight > curLeft) {
                int t = nums[curRight];
                nums[curRight] = nums[curLeft];
                nums[curLeft] = t;
            }
        }
        nums[left] = nums[curRight];
        nums[curRight] = val;
        if (curLeft + 1 == k) {
            return nums[curLeft];
        }
        if (curLeft + 1 > k) {
            return process(nums, left, curLeft - 1, k);
        } else {
            return process(nums, curRight + 1, right, k);
        }
    }
}
