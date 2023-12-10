package com.trip.algorithm.leet.some.leet2311;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author xbguo
 * @date 2023/11/27 18:45
 */
public class Solution907 {
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
       // int[] arr={11,81,94,43,3};
        Solution907 solution907 =new Solution907();
        int i = solution907.sumSubarrayMins(arr);
        System.out.println(i);
       // System.out.println(solution907.sumSubarrayMins1(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int cur = arr[i];
            while (!queue.isEmpty() && arr[queue.peekLast()] > cur) {
                queue.pollLast();
            }
            if (queue.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = queue.peekLast();
            }
            queue.addLast(i);
        }
        queue.clear();
        for (int j = len - 1; j >= 0; j--) {
            int cur = arr[j];
            while (!queue.isEmpty() && arr[queue.peekLast()] >= cur) {
                queue.pollLast();
            }
            if (queue.isEmpty()) {
                right[j] = len;
            } else {
                right[j] = queue.peekLast();
            }
            queue.addLast(j);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }

        private static final int MOD = 1000000007;
        public int sumSubarrayMins1(int[] arr) {
            int length = arr.length;
            int[] left = new int[length];
            int[] right = new int[length];

            Stack<Integer> list = new Stack<>();
            for (int i = 0; i < length; i++) {
                int cur = arr[i];
                while (!list.isEmpty() && arr[list.peek()] >= cur) {
                    list.pop();
                }
                if (list.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = list.peek();
                }
                list.add(i);
            }
            list.clear();
            for (int i = length - 1; i >= 0; i--) {
                int cur = arr[i];
                while (!list.isEmpty() && arr[list.peek()] > cur) {
                    list.pop();
                }
                if (list.isEmpty()) {
                    right[i] = length;
                } else {
                    right[i] = list.peek();
                }
                list.add(i);
            }
            long ans = 0;
            for (int i = 0; i < length; i++) {
                ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
            }
            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
            return (int) ans;
        }
}
