package com.trip.algorithm.leet.some.codeThink.mapcode;

/**
 * @author xbguo
 * @createTime 2022年11月13日 19:37:00
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 通过次数151,711提交次数297,187
 */
public class Solution495 {
    public static void main(String[] args) {
        Solution495 solution495 = new Solution495();
        String s = "abcabcabdabcabcabd";
        boolean b = solution495.repeatedSubstringPattern(s);
        System.out.println(b);
    }

    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];
        int j = 0;
        int len = 0;
        for (int i = 1; i < next.length; i++) {
            while (chars[i] != chars[j] && j > 0) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
            if (j!=0&&(i + 1) % j == 0&&(i + 1)/ j==2) {
                len =  j;
            }
        }
        if (len == 0) {
            return false;
        }
        String substring = s.substring(0, len);
        int x = s.length() / len;
        StringBuilder stringBuilder = new StringBuilder();
        while (x > 0) {
            stringBuilder.append(substring);
            x--;
        }
        return stringBuilder.toString().equals(s);
    }
}
