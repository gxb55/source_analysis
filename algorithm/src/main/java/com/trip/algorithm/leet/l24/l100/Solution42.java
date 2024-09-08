package com.trip.algorithm.leet.l24.l100;

import java.util.Deque;
import java.util.LinkedList;

public class Solution42 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 4};
        // int[] arr = {4, 2, 3};
        int trap = trap1(arr);
        System.out.println(trap);
        trap = trap2(arr);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int sum = 0;
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];
        int leftMax = height[0];
        for (int i = 0; i < height.length; i++) {
            leftArr[i] = Math.max(leftMax, height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        leftMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            rightArr[i] = Math.max(leftMax, height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftArr[i - 1], rightArr[i + 1]);
            if (height[i] < min) {
                sum = sum - height[i] + min;
            }
        }
        return sum;
    }

    public static int trap1(int[] height) {
        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {

            while (!list.isEmpty() && height[i] > height[list.peekLast()]) {
                Integer index = list.pollLast();
                if (list.isEmpty()) {
                    break;
                }
                Integer leftIndex = list.peekLast();
                int w = i - leftIndex - 1;
                int h= Math.min(height[i],height[leftIndex])-height[index];
                int v = h*w;
                // 下标出去，只计算了他左边和右边的值，后面还会继续贡献
                res = res + v;
            }
            list.addLast(i);
        }
        return res;
    }

    public static int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

}
