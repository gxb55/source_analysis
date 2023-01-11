package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/8/10  18:50
 * @description 438
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * 通过次数215,886提交次数394,410
 */
public class Solution438 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
         //String s = "cbaebabacd", p = "abc";
        String s = "abab", p = "ab";
        List<Integer> anagrams = solution438.findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int length = p.length();
        char[] chars1 = p.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> curMap = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            char c = chars1[i];
            Integer integer = map.get(c);
            if (integer != null) {
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char aChar = chars[i];
            if (i < length) {
                Integer integer = curMap.get(aChar);
                if (integer == null) {
                    curMap.put(aChar, 1);
                } else {
                    curMap.put(aChar, integer + 1);
                }
            } else {
                char aChar1 = chars[i - p.length()];
                curMap.put(aChar1, curMap.get(aChar1) - 1);
                if(curMap.get(aChar1)==0){
                    curMap.remove(aChar1);
                }
                Integer integer = curMap.get(aChar);
                if (integer == null) {
                    curMap.put(aChar, 1);
                } else {
                    curMap.put(aChar, integer + 1);
                }
            }
            if (i >= p.length()-1) {
                if (check(curMap, map)) {
                    list.add(i - p.length()+1);
                }
            }
        }
        return list;
    }

    private boolean check(HashMap curMap, HashMap map) {
        if (curMap.size() != map.size()) {
            return false;
        }
        Set<Map.Entry> set = curMap.entrySet();
        for (Map.Entry entry : set) {
            if (!entry.getValue().equals(map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
