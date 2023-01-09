package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/4/28  11:07
 * @description 91
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * 通过次数209,364提交次数653,074
 */
public class Solution91 {
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        // int i = solution91.numDecodings("111111111111111111111111111111111111111111111");
        int i = solution91.numDecodings("11106");
        System.out.println(i);
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 1;
        }
        int index = 0;
        return process(s, index);
    }

    public Map<String, Integer> map = new HashMap<>();

    private int process(String str, int index) {
        if (str.length() == index) {
            return 1;
        }
        String substring = str.substring(index);
        if (map.containsKey(substring)) {
            return map.get(substring);
        }
        int p1 = 0;
        int p2 = 0;
        if (index + 1 <= str.length() && check(str, index, index + 1)) {
            p1 = process(str, index + 1);
            map.put(str.substring(index + 1), p1);
        }
        if (index + 2 <= str.length() && check(str, index, index + 2)) {
            p2 = process(str, index + 2);
            map.put(str.substring(index + 2), p2);
        }
        return p1 + p2;
    }

    private boolean check(String str, int index, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = index; j < i; j++) {
            stringBuilder.append(str.charAt(j));
        }
        String s = stringBuilder.toString();
        if (s.startsWith("0")) {
            return false;
        }
        Integer integer = Integer.valueOf(s);
        return integer < 27;
    }
}
