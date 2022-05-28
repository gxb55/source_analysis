package com.trip.algorithm.zuo.trainingcamp3.class03;

/**
 * 请注意区分子串和子序列的不同，给定两个字符串str1和str2，
 * 求两个字符的最长公共子序列
 * <p>
 * 1.最长公共子序列可以不连续
 * 2.最长公共子串要连续，连续需要对角线的
 * <p>
 * 动态规划的空间压缩技巧！
 */
public class Code04_LCSubsequence {
    public static void main(String[] args) {
       /* String str1="AS123AD";
        String str2="A1231AD";
        lcse(str1,str2);*/
        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(lcse(str1, str2));
    }

    /**
     * @param str1
     * @param str2
     * @return
     */
    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i = chars1.length;
        int j = chars2.length;
        int[][] dp = new int[i][j];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int k = 1; k < i; k++) {
            dp[k][0] = chars1[k] == chars2[0] ? 1 : 0;
        }
        for (int k = 1; k < j; k++) {
            dp[0][k] = chars1[0] == chars2[k] ? 1 : 0;
        }
        int max=0;
        for (int k = 1; k < i; k++) {
            for (int l = 1; l < j; l++) {
                if (chars1[k] == chars2[l]) {
                    dp[k][l] = 1 + getMax(dp, k - 1, l );
                } else {
                    dp[k][l] = 0;
                }
                max = Math.max(dp[k][l],max);
            }
        }
        System.out.println(max);
        return null;
    }

    private static int getMax(int[][] dp, int i, int j) {
        int max = 0;
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                max = Math.max(max, dp[k][l]);
            }
        }
        return max;
    }
}
