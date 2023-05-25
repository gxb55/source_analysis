package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2023/5/23 11:05
 */
public class Solution84 {
    public static void main(String[] args) {
      //  int[] heights = {2, 1, 5, 6, 2, 3};
       // int[] heights = {2,4};
        int[] heights = {1,1};
        int i = largestRectangleArea(heights);
        System.out.println(i);
        int x=18000;
        x=x-4300;
        x=x-1400;
        x=x-1500;
        System.out.println(x*7);
    }

    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!queue.isEmpty() && heights[queue.peekLast()] >= heights[i]) {
                queue.pollLast();
            }
            if (!queue.isEmpty()) {
                left[i] = queue.peekLast();
            }
            queue.add(i);
        }
        queue.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && heights[queue.peekLast()] >= heights[i]) {
                queue.pollLast();
            }
            if (!queue.isEmpty()) {
                right[i] = queue.peekLast();
            }
            queue.add(i);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            int leftVal = left[i];
            int rightVal = right[i];
            if (rightVal == -1) {
                rightVal = length;
            }
            sum = Math.max(sum, (rightVal - leftVal - 1) * height);
        }
        return sum;
    }
}
