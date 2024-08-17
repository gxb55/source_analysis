package com.trip.algorithm.leet.l24.l08;

import java.util.*;
import java.util.stream.Collectors;

public class Solution676_v1 {



    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        String[] arr = {"hello", "hallo", "leetcode", "judge"};
        dictionary.buildDict(arr);
        System.out.println(dictionary.search("juage"));
    }
}

class MagicDictionary {
    Map<Integer, Set<String>> map = new HashMap<>();

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            Set<String> orDefault = map.getOrDefault(s.length(), new HashSet<>());
            orDefault.add(s);
            map.put(s.length(), orDefault);
        }
    }

    public boolean search(String searchWord) {
        Set<String> strings = map.get(searchWord.length());
        if (strings == null) {
            return false;
        }
        List<String> collect = strings.stream().filter(x -> !x.equals(searchWord)).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        char[] charArray = searchWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            for (int j = 0; j < collect.size(); j++) {
                if(set.contains(j)){
                    continue;
                }
                char c1 = collect.get(j).toCharArray()[i];
                if (c1 != c) {
                    Integer i1 = map1.get(j);
                    if (i1 == null) {
                        map1.put(j, 1);
                    } else {
                        set.add(j);
                        map1.remove(j);
                    }
                }
            }

        }
        return !map1.isEmpty();
    }
}