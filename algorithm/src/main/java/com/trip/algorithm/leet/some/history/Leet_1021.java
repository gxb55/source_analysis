package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年05月28日 19:42:00
 * 1021. 删除最外层的括号
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * <p>
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 * 通过次数81,396提交次数100,825
 */
public class Leet_1021 {
    public static void main(String[] args) {
        Leet_1021 leet_1021 = new Leet_1021();
       // String str="(()())(())(()(()))";
        String str="()()";
        String s = leet_1021.removeOuterParentheses(str);
        System.out.println(s);
    }

    public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();
        List<String> stringList = new ArrayList<>();
        int x = 0;
        int y = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            stringBuilder.append(aChar);
            if (aChar == '(') {
                x++;
            } else if (aChar == ')') {
                y++;
            }
            if (x == y && x != 0) {
                stringList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        stringBuilder = new StringBuilder();
        for (String str : stringList) {
            String substring = str.substring(1, str.length() - 1);
            stringBuilder.append(substring);
        }
        return stringBuilder.toString();
    }
}
