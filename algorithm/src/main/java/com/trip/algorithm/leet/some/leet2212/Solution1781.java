package com.trip.algorithm.leet.some.leet2212;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年12月12日 21:38:00
 * Solution1781
 * <p>
 * 1781. 所有子字符串美丽值之和
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * <p>
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * <p>
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * 通过次数18,983提交次数28,934
 */
public class Solution1781 {
    public static void main(String[] args) {
        Solution1781 solution1781 = new Solution1781();
        //    String str = "aabcbaa";
        String str = "woqrqcvfdgkrafoqdktsfpeygawfpdlvaylgpxhufpvucmmztjoqmxhegdpeczbtvwrmnwrvlptscwwqbjstanyqbgoagxopvgtlyzsemgktcgciualltsquepotmtszbmejbwbtzlavpxnujdsdyrypfcfcfwdidglybzvzuznytwndidzumoekzuukxtpouudsfcohapfcjjmqwjgcvalzarugmzucheydwsncxgyojnfvgroihfckmbtqewxhuqihplprgyeaqhocivaupdfokwpliziwcmuxnebxeszxbsrmffwwdz";
        int i = solution1781.beautySum(str);
        System.out.println(i);
    }

    public int beautySum(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int[] dp = new int[26];
            int max = 0;
            for (int j = i; j < chars.length; j++) {
                int min = Integer.MAX_VALUE;
                dp[chars[j] - 'a']++;
                max = Math.max(dp[chars[j] - 'a'], max);

                for (int x : dp) {
                    if (x > 0) {
                        min = Math.min(min, x);
                    }
                }
                res = res + (max - min);
            }
        }
        return res;
    }

    private Set<String> process(char[] chars) {
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.setLength(0);
            for (int j = i; j < chars.length; j++) {
                stringBuilder.append(chars[j]);
            }
        }
        return set;
    }

    private void process(char[] chars, Set<String> set, int index, StringBuilder stringBuilder) {
        if (index > chars.length) {
            return;
        }
        if (stringBuilder.length() > 1) {
            set.add(stringBuilder.toString());
        }
        for (int i = index; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            process(chars, set, i + 1, stringBuilder);
            // stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    public int beautySum1(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        process(chars);
        int[] dp = new int[26];
        for (String str : set) {
            char[] chars1 = str.toCharArray();
            Arrays.fill(dp, -1);
            for (Character character : chars1) {
                dp[character - 'a']++;
            }
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int x : dp) {
                if (x != -1) {
                    max = Math.max(x, max);
                    min = Math.min(x, min);
                }
            }
            res = res + max - min;
        }
        return res;
    }

}
