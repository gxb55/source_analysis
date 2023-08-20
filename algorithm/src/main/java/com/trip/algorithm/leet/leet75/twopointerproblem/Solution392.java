package com.trip.algorithm.leet.leet75.twopointerproblem;

/**
 * @author xbguo
 * @date 2023/8/17 17:16
 */
public class Solution392 {
    public static void main(String[] args) {
        //String s = "abc", t = "ahbgdc";
        String s = "", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        // s是t的子序列
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            int left = i;
            int index = 0;
            // 第一个字母相同
            if (index<s.length()&&sChar[index] == tChar[left]) {
                while (index<s.length()&&left<t.length()) {
                    // 不同的话t的下标后移
                    if (sChar[index] != tChar[left]) {
                        left++;
                    } else {
                        index++;
                        left++;
                    }
                }
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }
}
