package com.trip.algorithm.leet.leet75.arraystringproblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/8/16 19:43
 */
public class Solution300 {
    public static void main(String[] args) {
      //  int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
       // int[] nums = {0,1,0,3,2,3};
        int[] nums = {7,7,7,7,7,7,7};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] >= o1[0] ? 1 : -1;
            }
        });
        int[] res = new int[nums.length];
        res[0] = 1;
        queue.add(new int[]{1, nums[0]});
        for (int i = 1; i < nums.length; i++) {
            List<int[]> list = new ArrayList<>();
            int num = nums[i];
            while (!queue.isEmpty() && queue.peek()[1] >= num) {
                list.add(queue.poll());
            }
            if (queue.isEmpty()) {
                queue.add(new int[]{1, num});
            } else {
                int[] peek = queue.peek();
                queue.add(new int[]{peek[0] + 1, num});
            }
            for (int[] arr : list) {
                queue.add(arr);
            }
        }
        return queue.peek()[0];
    }
}
