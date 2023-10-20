package com.trip.algorithm.leet.some.leet2310;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/10/18 09:54
 */
public class Solution2530 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        queue.add(5);
        queue.add(6);
        queue.add(8);
        queue.remove(6);
        queue.add(7);
     /*   int[] nums = {10, 10, 10, 10, 10};
        int k = 5;   */

        int[] nums = {1,10,3,3,3};
        int k = 3;
        long l = Solution2530.maxKelements(nums, k);
        System.out.println(l);
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int x : nums) {
            queue.add(x);
        }
        long sum = 0;
        while (k > 0) {
            Integer poll = queue.poll();
            sum += poll;
            double ceil = Math.ceil(poll / 3.0);
            queue.add((int) ceil);
            k--;
        }
        return sum;
    }
}
