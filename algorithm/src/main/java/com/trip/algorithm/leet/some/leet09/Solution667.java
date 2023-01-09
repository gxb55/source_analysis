package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/9/8  10:24
 * @description 667. 优美的排列 II
 */
public class Solution667 {
    public static void main(String[] args) {
        Solution667 solution667 = new Solution667();
        //int n = 3, k = 1;
        int n = 3, k = 2;
        int[] ints = solution667.constructArray(n, k);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }

    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        int left = 1;
        int right = n;
        int flag = 1;
        int count = -1;
        boolean isf = true;
        for (int i = 0; i < arr.length; i++) {
            if (flag == 1) {
                arr[i] = left;
                left++;
                flag = 2;
            } else if (flag == 2) {
                arr[i] = right;
                right--;
                flag = 1;
            } else {
                if (isf) {
                    arr[i] = left;
                    left++;
                } else {
                    arr[i] = right;
                    right--;
                }
            }
            count++;
            if (count == k - 1) {
                if (flag == 1) {
                    isf = false;
                } else {
                    isf = true;
                }
                flag = 3;
            }
        }
        return arr;
    }
}
