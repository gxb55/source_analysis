package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.add(new int[]{nums[i], i});
            } else {
                queue.add(new int[]{nums[i], i});
                int left = i - k;
                while (!queue.isEmpty() && queue.peek()[1] <= left) {
                    queue.poll();
                }
                res[index] = queue.peek()[0];
                index++;
            }
        }
        return res;
    }
}
