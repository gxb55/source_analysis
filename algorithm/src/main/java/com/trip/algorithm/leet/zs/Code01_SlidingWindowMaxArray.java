package com.trip.algorithm.leet.zs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2022年03月27日 15:54:00
 * 滑动窗口算法，单调栈
 * 求数组arr[]中 k个元素的最大值
 * 即 0 - k 最大值
 * 1 - k+1 最大值
 * 2 - k+2 最大值
 */
public class Code01_SlidingWindowMaxArray {
    public static void main(String[] args) {
        int[] arr = {4,8,5,4,3,3,6,7};
        int k = 3;
        int[] maxWindow = getMaxWindow(arr, k);
        System.out.println(Arrays.toString(maxWindow));
    }

    /**
     * @param arr 数组
     * @param w   数量
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        // r右边界
        for (int r = 0; r < arr.length; r++) {
            int t = arr[r];
            while (!list.isEmpty() && arr[list.peek()] <= t) {
                list.poll();
            }
            list.add(r);
            //窗口的左边界
            int k = r - w;
            if (list.peekFirst() == k) {
                list.pollFirst();
            }
            if (r >= w-1) {
                result[index] = arr[list.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
