package com.trip.algorithm.zuo.trainingcamp3.class01;

import java.util.Arrays;

/**
 * 给定一个正整数M，请构造出一个长度为M的数组arr，要求
 * 对任意的i、j、k三个位置，如果i<j<k，都有arr[i] + arr[k] != 2*arr[j]
 * 返回构造出的arr
 */
public class Code06_MakeNo {
    public static void main(String[] args) {
        int[] ints = makeNo(7);
        Arrays.stream(ints).forEach(x->{
            System.out.println(x);
        });
    }

    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }
        // 种子，分治的思想
        int mid = (size + 1) / 2;
        int[] ints = makeNo(mid);
        int[] arr = new int[size];
        int n = ints.length;
        for (int i = 0; i < n; i++) {
            arr[i] = ints[i] * 2;
        }
        for (int i = n; i < size; i++) {
            arr[i] = ints[i - n] * 2 + 1;
        }
        return arr;
    }
}
