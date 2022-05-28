package com.trip.algorithm.zuo.trainingcamp3.class05;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic、dc和rc，分别代表插入、删 除和替换一个字符的代价，返回将str1编辑成str2的最小代价。
 * 【举例】
 * str1="abc"，str2="adc"，ic=5，dc=3，rc=2 从"abc"编辑成"adc"，把'b'替换成'd'是代价最小的，所以返回2
 * str1="abc"，str2="adc"，ic=5，dc=3，rc=100 从"abc"编辑成"adc"，先删除'b'，然后插入'd'是代价最小的，所以返回8
 * str1="abc"，str2="abc"，ic=5，dc=3，rc=2 不用编辑了，本来就是一样的字符串，所以返回0
 * <p>
 * 动态规划，原始数组做行，目标数组做列
 */
public class Code02_EditCost {
    public static void main(String[] args) {
        String str1 = "ab12cd3";
        String str2 = "abcdf";
        System.out.println(minCost1(str1, str2, 5, 3, 2));
    }

    /**
     * @param str1 原字符串
     * @param str2 目标字符串
     * @param ic   插入字符串的代价，插入可以
     * @param dc   删除字符串的代价
     * @param rc   替换字符串的代价
     * @return 大类分为两类
     * i为原数组长度
     * j为目标数组长度
     * 当 char【i】 跟chars[j] 对应起来，则分为两种情况
     * 当 i=j-1,则需要一个插入
     * 当 i-1=j,则需要一个删除
     */
    public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length(); i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 1; i < str2.length(); i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1Chars[i-1] == str2Chars[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                // i-1 跟 j 对齐则需要删除一个
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                // i和j-1对齐则需要添加一个
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
