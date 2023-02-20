package com.trip.algorithm.codethink.greedyalgorithm;

import java.sql.SQLOutput;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/2/20 19:16
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4]
 *
 */
public class Solution1005 {
    public static void main(String[] args) {
        int[] nums = {2,-3,-1,5,-4};int k = 2;
        int i = largestSumAfterKNegations(nums, k);
        System.out.println(i);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> x - y);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (k > 0) {
            Integer poll = priorityQueue.poll();
            priorityQueue.add(-poll);
            k--;
        }
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            res = res + priorityQueue.poll();
        }

        return res;
    }
}
