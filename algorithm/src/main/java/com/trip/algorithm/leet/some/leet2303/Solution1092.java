package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @date 2023/3/28 16:01
 * 1092. 最短公共超序列
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 *
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 *
 *
 *
 * 示例：
 *
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 *
 *
 * 提示：
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 */
public class Solution1092 {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        String s = shortestCommonSupersequence(str1, str2);
        System.out.println(s);
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (chars[i] != chars1[j]) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int m = str1.length() - 1;
        int n = str2.length() - 1;
        while (m >= 0 && n >= 0) {
            if (chars[m] == chars1[n]) {
                stringBuffer.append(chars[m]);
                m--;
                n--;
            } else {
                if (dp[m + 1][n] > dp[m][n + 1]) {
                    stringBuffer.append(chars1[n]);
                    n--;
                } else {
                    stringBuffer.append(chars[m]);
                    m--;
                }
            }
        }
        if (m >= 0) {
            return str1.substring(0, m + 1) + stringBuffer.reverse();
        }
        if (n >= 0) {
            return str2.substring(0, n + 1) + stringBuffer.reverse();
        }

        return stringBuffer.reverse().toString();
    }
}
