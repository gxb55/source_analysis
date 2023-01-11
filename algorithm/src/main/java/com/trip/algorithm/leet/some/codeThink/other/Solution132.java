package com.trip.algorithm.leet.some.codeThink.other;

/**
 * @author xbguo
 * @createTime 2022年11月13日 20:49:00
 */
public class Solution132 {
    public static void main(String[] args) {

    }

    public int minCut(String s) {

        char[] chars = s.toCharArray();
        int length = s.length();
        int[][] dp = new int[length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < chars.length; i++) {

            if(dp[i-1][0]>0||dp[i-1][1]>0){
                if(chars[i]==chars[i-1]&&dp[i-1][0]>0){
                    dp[i][0]=dp[i-1][0]+1;
                }
                if(chars[i]==chars[dp[i-1][1]]){
                    dp[i][0]=dp[i-1][1]+2;
                }

            }
        }
        return 0;
    }
}
