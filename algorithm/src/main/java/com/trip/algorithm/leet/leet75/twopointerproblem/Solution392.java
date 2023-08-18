package com.trip.algorithm.leet.leet75.twopointerproblem;

/**
 * @author xbguo
 * @date 2023/8/17 17:16
 */
public class Solution392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        // s是t的子序列
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int y = 0;
        for (int i = 0; i < tChar.length; i++) {
            int left = i;
            if (tChar[y] == sChar[left]) {
                while (left < sChar.length && y < s.length()) {
                    while (tChar[y] != sChar[left]) {
                        y++;
                    }
                    y++;
                }
            }
            if (y == s.length()) {
                return true;
            }
        }
        return false;
    }
}
