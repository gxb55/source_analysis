package com.trip.algorithm.leet.some.leet11;

/**
 * @author xbguo
 * @date 2022/11/29 09:27
 * 1758. 生成交替二进制字符串的最少操作数
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * <p>
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * <p>
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s[i] 是 '0' 或 '1'
 * 通过次数14,805提交次数22,113
 */
public class Solution1758 {
    public static void main(String[] args) {
        Solution1758 solution1758 = new Solution1758();
       // String s = "0100";
        String s = "1111";
        int i = solution1758.minOperations(s);
        System.out.println(i);
    }

    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            char x = i % 2 == 0 ? '0' : '1';
            char y = (i + 1) % 2 == 0 ? '0' : '1';
            if (i == 0) {
                if (aChar == x) {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
                if (aChar == y) {
                    dp[i][1] = 0;
                } else {
                    dp[i][1] = 1;
                }
            } else {
                if (aChar == x) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    dp[i][0] = 1 + dp[i - 1][0];
                }
                if (aChar == y) {
                    dp[i][1] = dp[i - 1][1];
                } else {
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }

    public int minOperations1(String s) {
        int res1 = 0,res2 = 0;
        //讲原字符串变为 101010 形式需要的操作数
        for(int i=0;i<s.length();++i){
            if(i % 2 == 1){
                if(s.charAt(i) == '1') res1++;
            }else{
                if(s.charAt(i) == '0') res1++;
            }
        }
        //讲原字符串变为 010101 形式需要的操作数
        for(int i=0;i<s.length();++i){
            if(i % 2 == 1){
                if(s.charAt(i) == '0') res2++;
            }else{
                if(s.charAt(i) == '1') res2++;
            }
        }
        //取两者较小值
        return Math.min(res1,res2);
    }
}
