package com.trip.algorithm.countdown.dp.day0429;

/**
 * @author xbguo
 * @createTime 2023年04月29日 17:14:00
 * 639. 解码方法 II
 * 一条包含字母 A-Z 的消息通过以下的方式进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 * <p>
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * <p>
 * 由于答案数目可能非常大，返回 109 + 7 的 模 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 * 示例 2：
 * <p>
 * 输入：s = "1*"
 * 输出：18
 * 解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
 * 每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
 * 因此，"1*" 共有 9 * 2 = 18 种解码方法。
 * 示例 3：
 * <p>
 * 输入：s = "2*"
 * 输出：15
 * 解释：这一条编码消息可以表示 "21"、"22"、"23"、"24"、"25"、"26"、"27"、"28" 或 "29" 中的任意一条。
 * "21"、"22"、"23"、"24"、"25" 和 "26" 由 2 种解码方法，但 "27"、"28" 和 "29" 仅有 1 种解码方法。
 * 因此，"2*" 共有 (6 * 2) + (3 * 1) = 12 + 3 = 15 种解码方法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 是 0 - 9 中的一位数字或字符 '*'
 */
public class Solution639 {
    public static void main(String[] args) {
        String s = "1*";
         s = "**";
         s ="1*72*";
         s ="*********";
         s ="7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*";
        int i = numDecodings(s);
        System.out.println(i);
    }

    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        long[] dp = new long[s.length() + 1];
        dp[0] = 1L;
        dp[1] = 1L;
        char[] chars = s.toCharArray();
        if (chars[0] == '*') {
            dp[1] = 9L;
        }

        for (int i = 1; i < chars.length; i++) {
            Character curChar = chars[i];
            Character lastChar = chars[i - 1];
            if (curChar == '0') {
                if (lastChar == '*') {
                    dp[i + 1] = dp[i - 1] * 2;
                } else if (lastChar == '1' || lastChar == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (curChar == '*') {
                    if (lastChar == '1') {
                        dp[i + 1] = dp[i + 1]% 1000000007 + (dp[i] * 9)% 1000000007 + (dp[i - 1] * 9)% 1000000007;
                    } else if (lastChar == '2') {
                        dp[i + 1] = dp[i + 1]% 1000000007 +(dp[i] * 9)% 1000000007 + (dp[i - 1] * 6)% 1000000007;
                    } else if (lastChar == '*') {
                        dp[i + 1] = dp[i + 1]% 1000000007 + (dp[i] * 9)% 1000000007 + (dp[i - 1] * 9)% 1000000007 + (dp[i - 1] * 6)% 1000000007;
                    }else{
                        dp[i + 1] = dp[i + 1]% 1000000007 + (dp[i] * 9% 1000000007);
                    }
                } else {
                    dp[i + 1] = dp[i];
                    if (lastChar == '1') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1];
                    } else if (lastChar == '2' && curChar >= '1' && curChar <= '6') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1];
                    } else if (lastChar == '*') {
                        if (curChar >= '1' && curChar <= '6') {
                            dp[i + 1] = dp[i + 1] + dp[i - 1]* 2;
                        }else{
                            dp[i + 1] = dp[i + 1] + dp[i - 1]* 1;
                        }
                    }
                }
            }
            System.out.println(dp[i]+"_1");
            dp[i + 1] = dp[i + 1] % 1000000007;
            System.out.println(dp[i]+"_2");
            System.out.println("========");
        }
        return Math.toIntExact(dp[s.length()]);
    }
}
