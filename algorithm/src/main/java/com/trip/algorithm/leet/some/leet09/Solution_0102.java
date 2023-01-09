package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;

/**
 * 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * 通过次数96,933提交次数148,938
 */
public class Solution_0102 {
    public static void main(String[] args) {
        Solution_0102 solution_0102 = new Solution_0102();
       String  s1 = "abc", s2 = "bca";
        boolean b = solution_0102.CheckPermutation(s1,s2);
        System.out.println(b);
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }
}
