package com.trip.algorithm.codethink.stringcode;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2022/11/11 14:28
 * @description Solution151
 * 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
public class Solution151 {
    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s1 = "   the sky is     blue  ";
        String s = solution151.reverseWords1(s1);
        System.out.println(s);
    }

    public String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        LinkedList<String> queue = new LinkedList<>();
        for (String s2 : s1) {
            if (s2.equals("")) {
                continue;
            }
            queue.addLast(s2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.pollLast()).append(" ");

        }
        return stringBuilder.toString().trim();
    }

    public String reverseWords1(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        char[] chars = stringBuilder.reverse().toString().trim().toCharArray();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if(chars[i]==' '&& stringBuilder1.length()==0){
                    continue;
                }
                res.append(stringBuilder1.reverse()).append(" ");
                stringBuilder1.setLength(0);
            } else {
                stringBuilder1.append(chars[i]);
            }
        }
        res.append(stringBuilder1.reverse());
        return res.toString().trim();
    }
}
