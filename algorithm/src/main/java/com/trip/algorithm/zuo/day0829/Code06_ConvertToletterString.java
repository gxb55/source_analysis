package com.trip.algorithm.zuo.day0829;

import org.apache.commons.lang3.StringUtils;

/**
 * 数字转换为字符串
 * 1->a
 * 11->k
 */
public class Code06_ConvertToletterString {
    public static void main(String[] args) {
        int number = number("1112313453111");
        int dp = numberDp("1112313453111");
        System.out.println(number);
        System.out.println(dp);
    }

    public static int number(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        // 字符串转化为数组，从0位置开始往后尝试
        return process(str.toCharArray(), 0);
    }

    public static int numberDp(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        // 字符串转化为数组，从0位置开始往后尝试
        return dp(str.toCharArray(), 0);
    }

    /**
     * @param chars 目标数组
     * @param index 下标 从零开始
     *              分情况 处理
     * @return
     */
    public static int process(char[] chars, int index) {
        // 这种情况认为找到了一种情况，前面index-1个元素都找好了
        if (index == chars.length) {
            return 1;
        }

        // 0没法转化为字母，分支限界直接结束
        if (chars[index] == '0') {
            return 0;
        }
        if (chars[index] == '1') {
            /***
             * index
             * index，index +1
             * 分着两种情况，index+1<length;说明可以到index+2，如果index+2到了最大值那也没问题
             */
            int res = process(chars, index + 1);
            if (index + 1 < chars.length) {
                res = res + process(chars, index + 2);
            }
            return res;
        }
        if (chars[index] == '2') {
            int res = process(chars, index + 1);
            if (index + 1 < chars.length && chars[index + 1] <= '6' && chars[index + 1] > '0') {
                res = res + process(chars, index + 2);
            }
            return res;
        }
        return process(chars, index + 1);
    }

    /**
     * 1112313453111
     * @param chars
     * @param index
     * @return
     */
    public static int dp(char[] chars, int index) {
        int n = chars.length;
        int[] dp = new int[n + 1];
        dp[chars.length] = 1;

        for (int i = n-1; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            }else if (chars[i] == '1') {
                int res = dp[i + 1];
                if (i + 1 < chars.length) {
                    res = res + dp[i + 2];
                }
                dp[i] = res;
            }else if (chars[i] == '2') {
                int res = dp[i + 1];
                if (i + 1 < chars.length && chars[i + 1] <= '6' && chars[i + 1] > '0') {
                    res = res + dp[i + 2];
                }
                dp[i] = res;
            }else {
                dp[i] = dp[i+1];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        System.out.println("-----------");
        return dp[0];
    }
}
