package com.trip.algorithm.leet.leet75.Stackpriorityqueue;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年08月05日 18:48:00
 */
public class Solution2462 {
    public static void main(String[] args) {
        Solution2462 solution2462 = new Solution2462();
      /*  int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3, candidates = 4;*/

        /*int[] costs = {1,2,4,1};
        int k = 3, candidates = 3;*/

        int[] costs = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        int k = 11, candidates = 2;
        long l = solution2462.totalCost(costs, k, candidates);
        System.out.println(l);
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((x, y) -> x - y);
        int len = costs.length;
        long res = 0L;
        if (2 * candidates >= len) {
            for (int z : costs) {
                leftQueue.add(z);
            }
            while (k > 0) {
                res += leftQueue.poll();
                k--;
            }
        } else {
            for (int i = 0; i < candidates; i++) {
                leftQueue.add(costs[i]);
            }
            for (int i = costs.length - 1; i > costs.length - 1 - candidates; i--) {
                rightQueue.add(costs[i]);
            }
            int left = candidates;
            int right = costs.length - 1 - candidates;
            while (k > 0) {
                int v=0;
                if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                    Integer peek = leftQueue.peek();
                    Integer peek1 = rightQueue.peek();
                    if (peek <= peek1) {
                        v=leftQueue.peek();
                        res += leftQueue.poll();
                        if (left <= right) {
                            leftQueue.add(costs[left]);
                            left++;
                        }
                    } else {
                        v=rightQueue.peek();
                        res += rightQueue.poll();
                        if (left <= right) {
                            rightQueue.add(costs[right]);
                            right--;
                        }
                    }
                } else if (!leftQueue.isEmpty()) {
                    v=leftQueue.peek();
                    res += leftQueue.poll();
                    if (left <= right) {
                        leftQueue.add(costs[left]);
                        left++;
                    }
                } else {
                    v=rightQueue.peek();
                    res += rightQueue.poll();
                    if (left <= right) {
                        rightQueue.add(costs[right]);
                        right--;
                    }
                }
                System.out.println(v);
                k--;
            }
        }
        return res;
    }
}
