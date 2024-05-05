package com.trip.algorithm.leet.l24.l05;

import java.util.PriorityQueue;

public class Solution2462 {
    public static void main(String[] args) {
      /*  int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3, candidates = 4; */

        int[] costs = {17,12};
        int k = 1, candidates = 1;
        long l = totalCost(costs, k, candidates);
        System.out.println(l);
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int l = 0;
        int r = costs.length - 1;
        int count = 0;
        PriorityQueue<Integer> leftQue = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> rightQue = new PriorityQueue<>((x, y) -> x - y);
        for (; l < costs.length && count < candidates; l++, count++) {
            leftQue.add(costs[l]);
        }
        count = 0;
        for (; r >= l && count < candidates; r--, count++) {
            rightQue.add(costs[r]);
        }
        int min;
        boolean leftFlag, rightFlag;
        while (k > 0) {
            k--;
            leftFlag = false;
            rightFlag = false;
            min = Integer.MAX_VALUE;
            if (!leftQue.isEmpty()) {
                min = leftQue.poll();
                leftFlag = true;
            }
            if (!rightQue.isEmpty()) {
                Integer poll = rightQue.peek();
                if (poll < min) {
                    if (leftFlag) {
                        leftQue.add(min);
                    }
                    rightQue.poll();
                    rightFlag = true;
                    leftFlag = false;
                    min = poll;
                }
            }
            if (leftFlag && l <= r) {
                leftQue.add(costs[l]);
                l++;
            }
            if (rightFlag && l <= r) {
                rightQue.add(costs[r]);
                r--;
            }
            res += min;
        }
        return res;
    }
}
