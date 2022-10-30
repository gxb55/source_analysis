package com.trip.algorithm.leet.some.leet2208;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年08月22日 22:49:00
 * 归并排序
 */
public class Solution_MergeSort {
    public static void main(String[] args) {
        Solution_MergeSort solution_mergeSort = new Solution_MergeSort();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        solution_mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int[] result = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, result);
    }

    private void mergeSort(int[] arr, int left, int right, int[] result) {
        System.out.println(left+":"+right);
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);

        int l = left;
        int r = mid + 1;
        int index = left;
        while (l <= mid && r <= right) {
            if (arr[l] > arr[r]) {
                result[index++] = arr[l++];
            } else {
                result[index++] = arr[r++];
            }
        }

        while (l <= mid) {
            result[index++] = arr[l++];
        }

        while (r <= right) {
            result[index++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = result[i];
        }

    }
}
