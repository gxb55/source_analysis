package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @date 2023/6/30 10:29
 */
public class Solution2490 {
    public static void main(String[] args) {

    }

    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            String s1 = s[i];
            String s2 = s[i + 1];
            char c = s1.charAt(s1.length() - 1);
            char c1 = s2.charAt(0);
            if (c1 != c) {
                return false;
            }
        }
        String s1 = s[s.length - 1];
        char c = s1.charAt(s1.length() - 1);
        String s2 = s[0];
        char c1 = s2.charAt(0);
        if (c1 != c) {
            return false;
        }
        return true;
    }
}
