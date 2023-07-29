package com.trip.algorithm.leet.some.leet2307;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/7/25 09:57
 *
 * 输入：nums = [5,19,8,1]
 * 输出：3
 *
 * 输入：nums = [3,8,20]
 * 输出：3
 */
public class Solution2208 {
    public static void main(String[] args) {
       // int[] nums = {5,19,8,1};
       // int[] nums = {3,8,20};
        int[] nums = {1,1,1};
        int i = halveArray(nums);
        System.out.println(i);
    }

    public  static int halveArray(int[] nums) {
        double[] doubles = new double[nums.length];
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0])>0?1:-1);
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            doubles[i] = nums[i];
            queue.add(new double[]{nums[i], i});
            sum += nums[i];
        }
        double target = sum / 2;
        int count = 0;
        while (sum > target) {
            double[] poll = queue.poll();
            double v = poll[0];
            double v1 = v / 2;
            sum-=v1;
            queue.add(new double[]{v1,poll[1]});
            count++;
        }

        return count;
    }
}
