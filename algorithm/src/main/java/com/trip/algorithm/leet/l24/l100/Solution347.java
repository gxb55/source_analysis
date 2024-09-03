package com.trip.algorithm.leet.l24.l100;

import java.util.*;

public class Solution347 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 5, 3, 5, 3, 1, 1, 3};
        int k = 2;

        int[] ints = topKFrequent(arr, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int i = map.getOrDefault(x, 0) + 1;
            map.put(x, i);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                int[] peek = queue.peek();
                if (peek[1] > entry.getValue()) {
                    continue;
                } else {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll()[0];
        }
        return arr;
    }
}
