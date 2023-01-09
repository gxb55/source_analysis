package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/26  20:47
 * @description 2255
 * 2255. 统计是给定字符串前缀的字符串数目 显示英文描述
 * 通过的用户数2978
 * 尝试过的用户数3014
 * 用户总通过次数3009
 * 用户总提交次数3766
 * 题目难度Easy
 * 给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
 * <p>
 * 请你返回 words 中是字符串 s 前缀 的 字符串数目 。
 * <p>
 * 一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","b","c","ab","bc","abc"], s = "abc"
 * 输出：3
 * 解释：
 * words 中是 s = "abc" 前缀的字符串为：
 * "a" ，"ab" 和 "abc" 。
 * 所以 words 中是字符串 s 前缀的字符串数目为 3 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","a"], s = "aa"
 * 输出：2
 * 解释：
 * 两个字符串都是 s 的前缀。
 * 注意，相同的字符串可能在 words 中出现多次，它们应该被计数多次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, s.length <= 10
 * words[i] 和 s 只 包含小写英文字母。
 */
public class Solution2255 {
    public static void main(String[] args) {
        Solution2255 solution2255 = new Solution2255();
        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        int i = solution2255.countPrefixes(words, s);
        System.out.println(i);
    }

    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String str : words) {
            if (s.indexOf(str) == 0) {
                res++;
            }
        }
        return res;
    }

}
