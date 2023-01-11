package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/5/25  11:39
 * @description 467
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." .
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 * <p>
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 * <p>
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= p.length <= 105
 * p 由小写英文字母构成
 * 通过次数17,602提交次数36,176
 */
public class Solution467 {
    public static void main(String[] args) {
        Solution467 solution467 = new Solution467();
        int res = solution467.findSubstringInWraproundString("zab");
        System.out.println(res);
    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        dp[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            int val = p.charAt(i) - p.charAt(i - 1);
            int temp = p.charAt(i) - 'a';
            if (val == 1 || val == -25) {
                if(val==1){
                    dp[temp] = Math.max(dp[temp], dp[temp - 1] + 1);
                }else{
                    dp[temp] = Math.max(dp[temp], dp[25] + 1);
                }
            } else {
                dp[temp] = 1;
            }
        }
        return Arrays.stream(dp).sum();
    }

}
