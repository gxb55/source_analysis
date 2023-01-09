package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/11  10:14
 * @description Solution1417
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 *
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 *
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 *
 * 输入：s = "ab123"
 * 输出："1a2b3"
 */
public class Solution1417 {
    public static void main(String[] args) {
        Solution1417 solution1417 = new Solution1417();
        String s = "j";
        String reformat = solution1417.reformat(s);
        System.out.println(reformat);
    }

    public String reformat(String s) {
        List<Character> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (Character.isDigit(aChar)) {
                numList.add(aChar);
            } else {
                charList.add(aChar);
            }
        }
        if (Math.abs(numList.size() - charList.size()) > 1) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        if(numList.isEmpty()){
            for (Character character:charList){
                str.append(character);
            }
            return str.toString();
        }
        if(charList.isEmpty()){
            for (Character character:numList){
                str.append(character);
            }
            return str.toString();
        }
        int i = 0;
        int len = Math.min(numList.size(), charList.size());

        while (true) {
            str.append(numList.get(i));
            str.append(charList.get(i));
            i++;
            if (i >= len) {
                break;
            }
        }
        if (numList.size() == charList.size()) {
            return str.toString();
        } else if (numList.size() > charList.size()) {
            str.append(numList.get(i));
            return str.toString();
        } else   {
            return charList.get(i) + str.toString();
        }
    }
}
