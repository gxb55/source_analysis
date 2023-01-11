package com.trip.algorithm.leet.some.leet08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2022/8/29  15:32
 * @description 239
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class Solution239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
       /* int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;*/
        int[] nums = {1,  -1};
        int k = 1;
        int[] ints = solution239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1]-x[1]);
        int index=0;
        for (int i = 0; i < nums.length&&index<arr.length; i++) {
            int[] curArr = new int[]{i, nums[i]};
            if (queue.size() < k) {
                queue.add(curArr);
            } else {
                while (!queue.isEmpty()&&queue.peek()[0] <= (i - k)) {
                    queue.poll();
                }
                queue.add(curArr);
            }
            if(queue.size()>=k){
                arr[index] = queue.peek()[1];
                index++;
            }
        }
        return arr;
    }
}
