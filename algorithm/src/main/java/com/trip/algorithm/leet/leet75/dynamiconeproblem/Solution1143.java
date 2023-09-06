package com.trip.algorithm.leet.leet75.dynamiconeproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/9/6 17:32
 */
public class Solution1143 {
    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
     //   String text1 = "abcde", text2 = "ace";
        String text1 = "bl", text2 = "yby";
        int i = solution1143.longestCommonSubsequence1(text1, text2);
        System.out.println(i);
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1.equals(text2)) {
            return text1.length();
        }
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i][j];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int k = 1; k < i; k++) {
            dp[k][0] = Math.max(dp[k - 1][0],text1.charAt(k) == text2.charAt(0) ? 1 : 0);
        }
        for (int k = 1; k < j; k++) {
            dp[0][k] =  Math.max(dp[0][k-1],text1.charAt(0) == text2.charAt(k) ? 1 : 0);
        }
        for (int k = 1; k < i; k++) {
            for (int l = 1; l < j; l++) {
                if (text1.charAt(k) == text2.charAt(l)) {
                    dp[k][l] = dp[k - 1][l - 1] + 1;
                }
                dp[k][l] = Math.max(dp[k - 1][l], dp[k][l]);
                dp[k][l] = Math.max(dp[k][l - 1], dp[k][l]);
            }
        }
        return dp[i - 1][j - 1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2)) {
            return text1.length();
        }
        char[] chars = text1.toCharArray();
        char[] chars1 = text2.toCharArray();
        return process(chars1, chars, 0, 0, 0);
    }

    Map<String, Integer> map = new HashMap<>();

    private int process(char[] chars1, char[] chars, int index1, int index, int length) {
        if (index1 >= chars1.length || index >= chars.length) {
            return 0;
        }
        int p1 = 0, p2 = 0, p3 = 0;
        if (chars[index] == chars1[index1]) {
            p1 = process(chars1, chars, index1 + 1, index + 1, length) + 1;
        }
        p2 = process(chars1, chars, index1 + 1, index, length);
        p3 = process(chars1, chars, index1, index + 1, length);
        int max1 = Math.max(p3, Math.max(p1, p2));
        map.put(index1 + "-" + index, max1);
        return max1;
    }
}
