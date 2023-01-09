package com.trip.algorithm.leet.some.leet10;

import java.util.Arrays;

/**
 * @auther: xbguo
 * @date: 2022/10/24 19:11
 * @description: Solution_lcp_19
 */
public class Solution_lcp_19 {
    public static void main(String[] args) {
        Solution_lcp_19 solution_lcp_19 = new Solution_lcp_19();
        String str = "rrryyyrryyyrr";
        str = "ryr";
        int i = solution_lcp_19.minimumOperations(str);
        System.out.println(i);

    }

    public int minimumOperations(String leaves) {
        int len = leaves.length();
        int[] left = new int[len];
        int[] right = new int[len];
        char[] chars = leaves.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (i == 0) {
                if (aChar != 'r') {
                    left[i] = 1;
                }
            } else {
                if (aChar != 'r') {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = left[i - 1];
                }
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if (i == chars.length - 1) {
                if (aChar != 'r') {
                    right[i] = 1;
                }
            } else {
                if (aChar != 'r') {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = right[i + 1];
                }
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int min = len;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 2; j < len - 1; j++) {
                int val = left[i] + right[j] + (j - i - 2) - (left[j - 1] - left[i + 1]);
                min = Math.min(min, val);
            }
        }

        return min == len ? 0 : min;
    }

    public int minimumOperations1(String leaves) {
        int n = leaves.length();
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isYellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }

}
