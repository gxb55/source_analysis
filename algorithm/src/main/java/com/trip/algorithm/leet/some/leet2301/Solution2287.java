package com.trip.algorithm.leet.some.leet2301;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/13 10:11
 * @description 2287
 */
public class Solution2287 {
    public static void main(String[] args) {
        Solution2287 solution2287 = new Solution2287();
        String s = "ilovecodingonleetcode", target = "code";
        int i = solution2287.rearrangeCharacters(s, target);
        System.out.println(i);
    }

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        char[] chars = s.toCharArray();
        for (Character character : chars) {
            Integer integer = map.get(character);
            if (integer == null) {
                map.put(character, 1);
            } else {
                map.put(character, integer + 1);
            }
        }
        char[] chars1 = target.toCharArray();
        for (Character character : chars1) {
            Integer integer = map1.get(character);
            if (integer == null) {
                map1.put(character, 1);
            } else {
                map1.put(character, integer + 1);
            }
        }
        int res = -1;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer value = entry.getValue();
            Character key = entry.getKey();
            if (res == -1) {
                Integer integer = map.get(key);
                if (integer == null) {
                    return 0;
                } else {
                    res = integer / value;
                }
            } else {
                Integer integer = map.get(key);
                if (integer == null) {
                    return 0;
                } else {
                    res = Math.min(integer / value, res);
                }
            }
        }
        return res;
    }
}
