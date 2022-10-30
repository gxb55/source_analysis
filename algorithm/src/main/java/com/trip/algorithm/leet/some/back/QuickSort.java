package com.trip.algorithm.leet.some.back;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年10月16日 19:33:00
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
       /* int[] arr = {20, 13, 24, 15, 1, 23, 45, 0, 1, -1};
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/

        int[] arr1 = {2,3,4,5,6,7,8,9,90,-1};
        quickSort.sort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 1.先获取大的值，这样停下来的时候肯定是比目标值小的
     * 2.在比较的过程中，左边和右边都要计算等于的情况，下标判断放在前面
     * @param arr
     * @param beginIndex
     * @param endIndex
     */
    public void sort(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int curVal = arr[beginIndex];
        int l = beginIndex;
        int r = endIndex;
        while (l < r) {
            while (r > l && arr[r] >= curVal) {
                r--;
            }
            while (r > l && arr[l] <= curVal) {
                l++;
            }
            if (r > l) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        arr[beginIndex] = arr[l];
        arr[l] = curVal;
        sort(arr, beginIndex, l);
        sort(arr, l + 1, endIndex);
    }
}
