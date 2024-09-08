package com.trip.algorithm.leet.l24.l100;

public class Solution11 {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        int i = maxArea(arr);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]),max);
            // 移动左边
            if (height[left] < height[right]) {
                left++;
            } else {
                // 移动右边
                right--;
            }
        }
        return max;
    }
}
