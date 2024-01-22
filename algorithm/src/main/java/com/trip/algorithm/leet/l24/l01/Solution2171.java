package com.trip.algorithm.leet.l24.l01;

import java.util.Arrays;

public class Solution2171 {
    public static void main(String[] args) {
        Solution2171 solution2171 = new Solution2171();
      //  int[] arr = {4, 1, 6, 5};
        int[] arr = {2, 10, 3, 2};
        long l = solution2171.minimumRemoval(arr);
        System.out.println(l);
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int x : beans) {
            sum += x;
        }
        Arrays.sort(beans);
        long res = sum;
        int len = beans.length;
        for (int i = 0; i < beans.length; i++) {
            if (beans[i] == 0) {
                continue;
            }
            int val = beans[i];
            long curVal = (len - (i + 1)) * val + val;
            res = Math.min(sum - curVal, res);
        }
        return res;
    }
}
