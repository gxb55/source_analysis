package com.trip.algorithm.leet.some.leet2311;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/11/2 10:51
 */
public class Solution2103 {
    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        int i = countPoints(rings);
        System.out.println(i);
    }

    public static int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char c1 = rings.charAt(i);
            char c2 = rings.charAt(i + 1);
            Set<Character> orDefault = map.getOrDefault(c2, new HashSet<>());
            orDefault.add(c1);
            map.put(c2, orDefault);
        }
        long count = map.values().stream().filter(x -> x.size() >= 3).count();
        return (int) count;
    }
}
