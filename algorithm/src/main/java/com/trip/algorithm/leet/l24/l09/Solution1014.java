package com.trip.algorithm.leet.l24.l09;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1014 {
    public static void main(String[] args) {
       // int[] arr = {4, 6, 8, 1, 1, 1, 10};
        int[] arr = {8,1,5,2,6};
        int i = maxScoreSightseeingPair(arr);
        System.out.println(i);
    }

    public static int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<int[]> right = new PriorityQueue<>((x, y) -> {
            int i = x[0] - x[1];
            int j = y[0] - y[1];
            return j > i ? 1 : -1;
        });
        Map<Integer, int[]> map = new HashMap<>();
        PriorityQueue<int[]> left = new PriorityQueue<>((x, y) -> {
            int i = x[0] - x[1];
            int j = y[0] - y[1];
            return j > i ? 1 : -1;
        });
        for (int i = 0; i < values.length; i++) {
            int[] ints = {values[i], i};
            right.add(ints);
            map.put(i, ints);
        }
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (!left.isEmpty()) {
                int[] peek = left.peek();
                max = Math.max(max, values[i] + peek[0] + peek[1] - i);
            }
            left.add(new int[]{values[i], i});
            right.remove(map.get(i));
            if (!right.isEmpty()) {
                int[] peek = right.peek();
                max = Math.max(max, values[i] + peek[0] + i - peek[1]);
            }

        }
        return max;
    }
}
