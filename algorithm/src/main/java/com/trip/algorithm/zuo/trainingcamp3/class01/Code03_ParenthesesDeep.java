package com.trip.algorithm.zuo.trainingcamp3.class01;

import java.util.Objects;

/**
 * 括号有效配对是指：
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 * 有效的：    (())  ()()   (()())  等
 * 无效的：     (()   )(     等
 * 问题一：怎么判断一个括号字符串有效？
 * 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 */
public class Code03_ParenthesesDeep {
    public static void main(String[] args) {
        String test = "((()))";
        String test1 = ")))()((())))";
        System.out.println(isValid(test1));
        System.out.println(needBrackets(test1));
        System.out.println(maxLength(test1));
    }

    /**
     * 括号是否匹配
     *
     * @param str
     * @return
     */
    public static boolean isValid(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 如果不合法还需要多少才能合法
     *
     * @param str
     * @return
     */
    public static int needBrackets(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                if (count == 0) {
                    need++;
                } else {
                    count--;
                }
            }
        }
        return need + count;
    }

    /**
     * 连续子串 最长的合法的子串有多长 动态规划来做
     * 1.每次遇到左括号说明以当前字符结尾的为0个
     * 2.每次遇到右括号,则看前一个字符的有效长度是多少，根据公式
     * pre = dp[i-1]-1
     *
     * @param s
     * @return
     */
    public static int maxLength(String s) {
        if (Objects.isNull(s) || s.length() <= 1) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] dp = new int[length];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                // 上一个字符是多少可能就是上一个，也可能是上n个
                int pre = i - dp[i - 1] - 1;
                //chars[pre] 上一个非连续子串
                if (pre >= 0 && chars[pre] == '(') {
                    //pre > 0 ? dp[pre - 1] : 0 非连续子串的上一个
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
