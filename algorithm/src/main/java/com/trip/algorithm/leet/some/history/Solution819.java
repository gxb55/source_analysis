package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/17  17:26
 * @description Solution819
 */
public class Solution819 {
    public static void main(String[] args) {

       // String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph =   "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        Solution819 solution819 = new Solution819();
        String s = solution819.mostCommonWord(paragraph, banned);
        System.out.println(s);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String replace = paragraph.replace(", ", " ")
                .replace(",", " ")
                .replace(".", "")
                .replace("?", "")
                .replace("'", "")
                .replace(";", "")
                .replace("!", "");


        String[] s = replace.split(" ");
        Set<String> set = new HashSet<>();
        for (String b : banned) {
            set.add(b);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : s) {
            str = str.toLowerCase(Locale.ROOT);
            if (!set.contains(str)) {
                int len = 1;
                if (map.containsKey(str)) {
                    len = map.get(str) + 1;
                }
                map.put(str, len);
            }
        }
        return map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).map(x -> x.getKey()).findFirst().orElse("");
    }
}
