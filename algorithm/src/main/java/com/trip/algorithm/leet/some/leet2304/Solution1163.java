package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/24 11:28
 * <p>
 * 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："tcode"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 4 * 105
 * s 仅含有小写英文字符。
 * 通过次数12,165提交次数38,813
 */
public class Solution1163 {
    public static void main(String[] args) {

    }

    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        Character character = chars[0];
        List<Integer> list = new ArrayList<>();
        for (Character character1 : chars) {
            if (character1 > character) {
                character = character1;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character) {
                list.add(i);
            }
        }
        String res= String.valueOf(character);
        for (int i = 0; i < s.length(); i++) {
            if(list.contains(Integer.valueOf(i))){

                for (int j = 0; j < s.length(); j++) {

                }
            }
        }
        return null;
    }
}
