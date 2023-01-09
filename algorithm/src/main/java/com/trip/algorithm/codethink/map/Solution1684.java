package com.trip.algorithm.codethink.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xbguo
 * @date: 2022/11/8 10:00
 * @description: TODO
 */
public class Solution1684 {
    public static void main(String[] args) {
        Solution1684 solution1684 = new Solution1684();
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int i = solution1684.countConsistentStrings(allowed, words);
        String a="{\"minPrice\":5,\"lastBuyHours\":1,\"noSaleTrainNum\":[]}";
        System.out.println(i);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int x = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = allowed.toCharArray();
        for (Character character : chars) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        boolean flag;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars1 = word.toCharArray();
            flag = true;
            for (Character character : chars1) {
                if (!map.containsKey(character)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                x++;
            }
        }
        return x;
    }
}
