package com.trip.algorithm.leet.some;

/**
 * @author xbguo
 * @createTime 2022年04月09日 17:41:00
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 通过次数974,245提交次数2,673,297
 *
 * todo 动态规划法
 */
public class Leet_5 {
    public static void main(String[] args) {
        Leet_5 leet_5 = new Leet_5();
        String s = leet_5.longestPalindrome1("cbbd");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        String result = String.valueOf(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (check(chars, i, j) && (j - i + 1) > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    private boolean check(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        String result = String.valueOf(chars[0]);
        if (s.length() == 2) {
            if (chars[0] == chars[chars.length - 1]) {
                return s;
            } else {
                return result;
            }
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < chars.length-1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    if ((right - left + 1) > (max - min)) {
                        min = left;
                        max = right;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    if ((right - left + 1) > (max - min)) {
                        min = left;
                        max = right;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }
        return s.substring(min, max + 1);
    }
}
