package com.trip.algorithm.leet.some.leet11;

/**
 * @auther: xbguo
 * @date: 2022/11/3 09:24
 * @description: Solution1668
 * 1668. 最大重复子字符串
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 */
public class Solution1668 {
    public static void main(String[] args) {
        Solution1668 solution1668 = new Solution1668();
        // String sequence = "ababc", word = "ab";
        //  String sequence = "a", word = "a";

        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        // String sequence = "ababc", word = "ba";
        // String sequence = "ababc", word = "ac";
        int i = solution1668.maxRepeating(sequence, word);
        System.out.println(i);
    }

    public int maxRepeating(String sequence, String word) {
        if (!sequence.contains(word)) {
            return 0;
        }
        int index = 0;
        int i;
        int max = 0;
        char[] chars = sequence.toCharArray();
        char[] chars1 = word.toCharArray();
        while (index < chars.length) {
            char c = chars[index];
            char c1 = chars1[0];
            if (c == c1) {
                int cur = index;
                temp:
                while (true) {
                    if (index >= chars.length) {
                        break;
                    }
                    i = 0;
                    for (; index < chars.length && i < word.length(); index++, i++) {
                        c = chars[index];
                        c1 = chars1[i];
                        if (c != c1) {
                            break temp;
                        }
                    }
                }
                max = Math.max(max, ((index - cur) / word.length()));
                index = cur;
            }
            index++;

        }
        return max;
    }
}
