package com.trip.algorithm.leet.some.back;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年10月16日 20:11:00
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        //int[] arr = {20, 13, 24, 15, 1, 23, 45, 0, 1, -1};
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 90, -1};
        int[] sort = mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    public int[] sort(int[] arr, int l, int r) {
        if (l >= r) {
            return new int[]{arr[l]};
        }
        int mid = l + (r - l) / 2;
        int[] arr1 = sort(arr, l, mid);
        int[] arr2 = sort(arr, mid + 1, r);
        return merge(arr1, arr2);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int l = 0;
        int l1 = 0;
        int index = 0;
        while (l < arr1.length && l1 < arr2.length) {
            if (arr1[l] < arr2[l1]) {
                arr[index] = arr1[l];
                l++;
            } else {
                arr[index] = arr2[l1];
                l1++;
            }
            index++;
        }
        while (l < arr1.length) {
            arr[index] = arr1[l];
            l++;
            index++;
        }
        while (l1 < arr2.length) {
            arr[index] = arr2[l1];
            l1++;
            index++;
        }
        return arr;
    }

}
