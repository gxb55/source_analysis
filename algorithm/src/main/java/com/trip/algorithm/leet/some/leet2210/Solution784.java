package com.trip.algorithm.leet.some.leet2210;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年10月30日 13:57:00
 * 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */
public class Solution784 {
    public static void main(String[] args) {
        Solution784 solution784 = new Solution784();
        //String s = "a1b2";
        String s = "3z4";
        List<String> list = solution784.letterCasePermutation(s);
        System.out.println(list);
    }



    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        process(chars, stringBuilder, 0);
        return res;
    }
    List<String> res;
    private void process(char[] chars, StringBuilder stringBuilder, int index) {
        if (index == chars.length) {
            res.add(stringBuilder.toString());
            return;
        }
        char aChar = chars[index];
        if (aChar >= '0' && aChar <= '9') {
            stringBuilder.append(aChar);
            process(chars, stringBuilder, index + 1);
            stringBuilder.setLength(stringBuilder.length() - 1);
        } else if (aChar >= 'a' && aChar <= 'z') {
            stringBuilder.append(aChar);
            process(chars, stringBuilder, index + 1);
            stringBuilder.setLength(stringBuilder.length() - 1);

            stringBuilder.append(String.valueOf(aChar).toUpperCase());
            process(chars, stringBuilder, index + 1);
            stringBuilder.setLength(stringBuilder.length() - 1);
        } else {
            stringBuilder.append(aChar);
            process(chars, stringBuilder, index + 1);
            stringBuilder.setLength(stringBuilder.length() - 1);

            stringBuilder.append(String.valueOf(aChar).toLowerCase());
            process(chars, stringBuilder, index + 1);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }
}
