package com.trip.algorithm.leet.some.codeThink.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年10月31日 22:04:00
 */
public class Solution76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        // String s = "ADOBECODEBANC", t = "ABC";
        String s = "aa", t = "a";
        String a = solution76.minWindow(s, t);
        System.out.println(a);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        String res = "";
        int left = 0;
        Map<Character, Integer> curMap = new HashMap<>();
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char aChar = chars1[i];
            if (curMap.containsKey(aChar)) {
                curMap.put(aChar, curMap.get(aChar) + 1);
            } else {
                curMap.put(aChar, 1);
            }
            if (curMap.size() >= map.size() && (i - left + 1) >= t.length()) {
                temp:
                while (true) {
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (entry.getValue() > curMap.getOrDefault(entry.getKey(), 0)) {
                            break temp;
                        }
                    }
                    String substring = s.substring(left, i + 1);
                    if (res.equals("") || res.length() > substring.length()) {
                        res = substring;
                    }
                    char c = chars1[left];
                    Integer integer = curMap.get(c);
                    if (integer == 1) {
                        curMap.remove(c);
                    } else {
                        curMap.put(c, curMap.get(c) - 1);
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
