package com.trip.algorithm.leet.some.leet2311;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/11/15 09:50
 */
public class Solution2656 {
    public static void main(String[] args) {
        Solution2656 solution2656 = new Solution2656();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int i = solution2656.maximizeSum(nums, k);
        System.out.println(i);
    }

    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            queue.add(num);
        }
        int sum = 0;
        while (!queue.isEmpty() && k > 0) {
            Integer poll = queue.poll();
            sum += poll;
            queue.add(poll + 1);
            k--;
        }
        return sum;
    }
}
