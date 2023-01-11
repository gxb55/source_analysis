package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @date 2023/1/9 09:16
 */
public class Solution1806 {
    public static void main(String[] args) {
        Solution1806 solution1806 = new Solution1806();
        int n = 6;
        int i = solution1806.reinitializePermutation(n);
        System.out.println(i);
    }

    /**
     * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
     * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
     *
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int index = 0;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            index++;
            if (check(arr)) {
                break;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    perm[i] = arr[i];
                }
            }
        }
        return index;
    }

    private boolean check(int[] arr) {
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            if (last > cur) {
                return false;
            } else {
                last = cur;
            }
        }
        return true;
    }
}
