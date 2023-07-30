package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年07月30日 21:17:00
 * 单调栈，但是会保证结果是正确的
 */
public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 按照真实的val降序排列，保证第一个就是最大的
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int[] res = new int[nums.length - k+1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
            if (i >= k-1) {
                while (queue.peek()[0] < (i - k + 1)) {
                    queue.poll();
                }
                res[index] = queue.peek()[1];
                index++;
            }
        }
        return res;
    }
}
