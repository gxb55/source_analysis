package com.trip.algorithm.leet.some.codeThink.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年11月13日 20:32:00
 */
public class Solution205 {
    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>(s.length());
        Map<Character, Character> map1 = new HashMap<>(s.length());
        for (int i = 0; i < chars1.length; i++) {
            char aChar = chars[i];
            char bChar = chars1[i];

            if (map.containsKey(aChar)) {
                if (map.get(aChar) != bChar) {
                    return false;
                }
            } else {
                map.put(aChar, bChar);
            }
            if (map1.containsKey(bChar)) {
                if (map1.get(bChar) != aChar) {
                    return false;
                }
            } else {
                map1.put(bChar, aChar);
            }
        }
        return true;
    }
}
