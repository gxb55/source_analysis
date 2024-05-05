package com.trip.algorithm.leet.l24.l05;

import java.util.Arrays;

public class Solution1652 {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] decrypt = decrypt(code, k);
        System.out.println(Arrays.toString(decrypt));
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
            return code;
        } else if (k > 0) {
            int[] res = new int[len];
            int sum = 0;
            for (int i = 1; i < k+1; i++) {
                sum += code[i % len];
            }
            res[0] = sum;
            for (int i = 1; i < res.length; i++) {
                sum -= code[i ];
                sum += code[(i + k )%len];
                res[i] = sum;
            }
            return res;
        } else {
            int[] res = new int[len];
            int sum = 0;
            int t = k;
            int i = len - 1;
            for (; i >= 0 && t < 0; i--, t++) {
                sum += code[i % len];
            }
            res[0] = sum;
            int right = i+1 ;
            for (int j = 1; j < res.length; j++, right++) {
                sum -= code[(right) % len];
                sum += code[j-1];
                res[j] = sum;
            }
            return res;
        }
    }
}
