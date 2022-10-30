package com.trip.algorithm.leet.some.leet2210;

/**
 * @author xbguo
 * @createTime 2022年10月23日 10:54:00
 * 1768. 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 *
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 *
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 * 通过次数27,151提交次数35,331
 */
public class Solution1768 {
    public static void main(String[] args) {
      //  String word1 = "abc", word2 = "pqr";
        String word1 = "ab", word2 = "pqrs";
        Solution1768 solution1768 = new Solution1768();
        String s = solution1768.mergeAlternately(word1, word2);
        System.out.println(s);
    }

    public String mergeAlternately(String word1, String word2) {
        int index = 0;
        int index1 = 0;
        int len = word1.length();
        int len1 = word2.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (index < len && index1 < len1) {
            stringBuilder.append(word1.charAt(index));
            stringBuilder.append(word2.charAt(index1));
            index++;
            index1++;
        }
        if (index < len) {
            stringBuilder.append(word1.substring(index));
        }
        if (index1 < len1) {
            stringBuilder.append(word2.substring(index1));
        }
        return stringBuilder.toString();
    }
}
