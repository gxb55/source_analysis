package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution2865 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 1);
        Solution2865 solution2865 = new Solution2865();
        long l = solution2865.maximumSumOfHeights(list);
        System.out.println(l);
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int len = maxHeights.size();
        long[] left = new long[len];
        long[] right = new long[len];
        for (int i = 0; i < len; i++) {
            Integer val = maxHeights.get(i);
            while (!deque.isEmpty() && val < maxHeights.get(deque.peek())) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                left[i] = (long) (i + 1) * val;
            } else {
                Integer peek = deque.peek();
                left[i] = (long) (i - peek) * val + left[peek];
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = len - 1; i >= 0; i--) {
            Integer val = maxHeights.get(i);
            while (!deque.isEmpty() && val < maxHeights.get(deque.peek())) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                right[i] = (long) (len - i) * val;
            } else {
                Integer peek = deque.peek();
                right[i] = (long) (peek - i) * val + right[peek];
            }
            deque.push(i);
            max = Math.max(max, left[i] + right[i] - val);
        }
        return max;
    }
}
