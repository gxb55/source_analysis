package com.trip.algorithm.leet.leet75.twopointerproblem;

/**
 * @author xbguo
 * @date 2023/8/17 16:30
 */
public class Solution11 {
    public static void main(String[] args) {

        // int[] arr={1,8,6,2,5,4,8,3,7};
        int[] arr = {1, 0, 0, 0, 0, 0, 0, 2, 2};
        int i = maxArea1(arr);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            if (left == 0) {
                continue;
            }
            if (max != 0 && (max / left) > (height.length - 1 - i)) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                int x = Math.min(left, right);
                max = Math.max(x * (j - i), max);
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int x = height[left];
            int y = height[right];
            /**
             * Math.min(x, y) * (right - left)
             * 无论移动那边 right - left 都会变小
             * 移动小的一边，则 Math.min(x, y) 可能更大
             * 移动大的一边，则小的一边不移动 则 Math.min(x, y) 肯定小于等于当前值
             */
            max = Math.max(Math.min(x, y) * (right - left), max);
            if (x < y) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


}
