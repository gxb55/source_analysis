package com.trip.algorithm.leet.some.leet2211;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年11月13日 09:50:00
 * 791. 自定义字符串排序
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * <p>
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * <p>
 * 返回 满足这个性质的 s 的任意排列 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 * <p>
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order 和 s 由小写英文字母组成
 * order 中的所有字符都 不同
 * 通过次数19,659提交次数27,339
 */
public class Solution791 {
    public static void main(String[] args) {
        Solution791 solution791 = new Solution791();
      //  String order = "cba", s = "abcd";
        String order = "cbafg", s = "abcd";
        String res = solution791.customSortString(order, s);
        System.out.println(res);
    }

    public String customSortString(String order, String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(order.length());
        for (Character character : chars) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars1 = order.toCharArray();
        for (Character character : chars1) {
            Integer integer = map.get(character);
            if (integer != null) {
                for (int i = 0; i < integer; i++) {
                    stringBuilder.append(character);
                }
                map.remove(character);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
