package com.trip.algorithm.leet.some.everday;

/**
 * @author xbguo
 * @createTime 2022年07月31日 21:52:00
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * 通过次数295,688提交次数804,094
 */
public class Solution32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        //String s="";
        // String s="(()";
        String s = ")(()()(())";
        int i = solution32.longestValidParentheses(s);
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                // 左括号默认是0
                dp[i] = 0;
            } else {
                // 上个位置是一个结尾，看结尾长度的前一个可不可以连上
                // 比如 （（）（））  最后一个是当前位置
                if (dp[i - 1] > 0) {
                    int val = i - 1 - (dp[i - 1]);
                    if (val >= 0 && chars[val] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        //比如 （）（）（（）（）） 这种情况
                        if ((val - 1) >= 0) {
                            dp[i] = dp[i] + dp[val - 1];
                        }
                    }
                } else {
                    // 上一个位置是一个（  ；（） 这种情况
                    if (chars[i - 1] == '(') {
                        int val = 0;
                        // 看i和i-1能不能和i-2配上  （）（） 这种情况看n-2能不能连上
                        if ((i - 2) >= 0) {
                            val = dp[i - 2];
                        }
                        dp[i] = val + 2;
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
