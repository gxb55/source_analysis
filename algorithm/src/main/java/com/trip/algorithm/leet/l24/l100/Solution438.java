package com.trip.algorithm.leet.l24.l100;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Solution438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        PriorityQueue<Integer> queue =new PriorityQueue<>(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.size());
        System.out.println(JSON.toJSONString(anagrams));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] charArray = p.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : charArray) {
            put(c, map);
        }
        List<Integer> res = new ArrayList<>();
        char[] charArray1 = s.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < charArray1.length; i++) {
            char c = charArray1[i];
            put(c, map1);
            if ((i + 1) >= p.length()) {
                if (map1.size() == map.size()) {
                    boolean b = map.entrySet().stream().allMatch(x -> Objects.equals(map1.get(x.getKey()), x.getValue()));
                    if (b) {
                        res.add(i - p.length() + 1);
                    }
                }
                char c1 = charArray1[i - p.length() + 1];
                Integer i1 = map1.get(c1);
                if (i1 == 1) {
                    map1.remove(c1);
                } else {
                    map1.put(c1, i1 - 1);
                }
            }
        }
        return res;
    }

    private static void put(Character c, Map<Character, Integer> map) {
        int i = map.getOrDefault(c, 0) + 1;
        map.put(c, i);
    }

}
