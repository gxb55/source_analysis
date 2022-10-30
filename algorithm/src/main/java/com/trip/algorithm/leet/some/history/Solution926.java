package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年06月11日 17:24:00
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 * 通过次数21,751提交次数35,504
 */
public class Solution926 {
    public static void main(String[] args) {
        Solution926 solution926 = new Solution926();
       // String s = "00110";
        String s = "11011";
        int i = solution926.minFlipsMonoIncr(s);
        System.out.println(i);
    }

    public int minFlipsMonoIncr(String s) {
        int max = s.length();
        char[] chars = s.toCharArray();
        int a = 0;
        int b = 0;
        for (Character character : chars) {
            if (character == '0') {
                a++;
            } else if (character == '1') {
                b++;
            }
        }
        max = Math.min(max, b);
        max = Math.min(max, a);
        if (max == 0) {
            return max;
        }
        int[] dp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (i == 0) {
                if (aChar == '0') {
                    dp[i] = a - 1;
                } else {
                    dp[i] = a + 1;
                }
            } else {
                if (aChar == '0') {
                    dp[i] = dp[i - 1] - 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        int asInt = Arrays.stream(dp).min().getAsInt();
        return Math.min(asInt,max);
    }
}
