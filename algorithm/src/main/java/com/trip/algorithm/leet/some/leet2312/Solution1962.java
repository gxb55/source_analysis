package com.trip.algorithm.leet.some.leet2312;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1962 {
    public static void main(String[] args) {
       /* int[] piles = {5, 4, 9};
        int k = 2; */

        int[] piles = {4,3,6,7};
        int k = 3;
        int i = minStoneSum(piles, k);
        System.out.println(i);
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y.compareTo(x));
        Arrays.stream(piles).forEach(x -> queue.add(x));
        while (k > 0) {
            Integer poll = queue.poll();
            queue.add((poll + 1) / 2);
            k--;
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}
