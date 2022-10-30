package com.trip.algorithm.leet.sort;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年10月17日 21:24:00
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9,-1,20,11,21};
        int[] sort = insertSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > curVal) {
                arr[index + 1] = arr[index];
                index--;
            }
            index++;
            arr[index] = curVal;
        }
        return arr;
    }
}
