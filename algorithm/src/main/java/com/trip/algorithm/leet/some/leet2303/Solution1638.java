package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/3/27 19:11
 * 1638. 统计只差一个字符的子串数目
 * 给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 恰好 只有一个字符不同的子字符串对的数目。
 *
 * 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。
 *
 * 请你返回满足上述条件的不同子字符串对数目。
 *
 * 一个 子字符串 是一个字符串中连续的字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 2：
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 3：
 * 输入：s = "a", t = "a"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "abe", t = "bbc"
 * 输出：10
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 100
 * s 和 t 都只包含小写英文字母。
 */
public class Solution1638 {
    public static void main(String[] args) {
        Solution1638 solution1638 = new Solution1638();
       // String s = "aba", t = "baba";
      //  String s = "ab", t = "bb";
     //   String s = "a", t = "a";
        String s = "abe", t = "bbc";
        int i = solution1638.countSubstrings(s, t);
        System.out.println(i);
    }

    public int countSubstrings(String s, String t) {
        Map<Integer, List<String>> sMap = getMap(s);
        Map<Integer, List<String>> tMap = getMap(t);
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (Map.Entry<Integer, List<String>> entry : sMap.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            List<String> list = tMap.get(key);
            if (list != null) {
                for (String s1 : value) {
                    int curSum = 0;
                    if (map.containsKey(s1)) {
                        curSum = map.get(s1);
                    } else {
                        for (String s2 : list) {
                            if (s1.equals(s2)) {
                                continue;
                            }
                            char[] chars = s1.toCharArray();
                            char[] chars1 = s2.toCharArray();
                            int count = 0;
                            for (int i = 0; i < chars1.length; i++) {
                                if (chars1[i] != chars[i]) {
                                    count++;
                                }
                                if (count >= 2) {
                                    break;
                                }
                            }
                            if (count == 1) {
                                curSum++;
                            }
                        }
                        map.put(s1, curSum);
                    }
                    res = res + curSum;
                }
            }
        }
        return res;
    }

    private Map<Integer, List<String>> getMap(String s) {
        Map<Integer, List<String>> map = new HashMap<>();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < length&&(j+i)<=length; j++) {
                list.add(s.substring(j, j + i));
            }
            map.put(i, list);
        }
        return map;
    }
}
