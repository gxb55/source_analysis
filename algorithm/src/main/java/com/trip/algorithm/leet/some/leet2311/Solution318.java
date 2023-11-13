package com.trip.algorithm.leet.some.leet2311;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年11月09日 22:15:00
 */
public class Solution318 {
    public static void main(String[] args) {
        Solution318 solution318 = new Solution318();
        // String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        int i = solution318.maxProduct(words);
        System.out.println(i);
    }

    public int maxProduct(String[] words) {
        List<Set<Character>> collect = Arrays.stream(words).map(x -> {
            return getSet(x);
        }).collect(Collectors.toList());

        int max = 0;
        for (int i = 0; i < collect.size(); i++) {
            Set<Character> set = collect.get(i);
            for (int j = i+1; j < collect.size(); j++) {
                Set<Character> set1 = collect.get(j);
                Set<Character> set2 = new HashSet<>(set1);
                set2.retainAll(set);
                if (set2.size() == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private Set<Character> getSet(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return set;
    }
}
