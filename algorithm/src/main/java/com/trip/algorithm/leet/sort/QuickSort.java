package com.trip.algorithm.leet.sort;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年06月30日 09:31:00
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        doSort(arr, l, r);
    }

    private static void doSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int val = arr[l];
        while (left < right) {
            while (left < right && arr[right] >= val) {
                right--;
            }
            while (left < right && arr[left] <= val) {
                left++;
            }
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[l];
        arr[l] = temp;
        doSort(arr, left, l - 1);
        doSort(arr, l + 1, right);
    }
}
