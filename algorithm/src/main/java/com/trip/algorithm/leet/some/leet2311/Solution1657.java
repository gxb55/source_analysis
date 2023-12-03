package com.trip.algorithm.leet.some.leet2311;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年11月30日 20:56:00
 */
public class Solution1657 {
    public static void main(String[] args) {
        Solution1657 solution1657 = new Solution1657();
        //   String word1 = "abc", word2 = "bca";
        // String word1 = "cabbba", word2 = "abbccc";
        //  String word1 = "cabbba", word2 = "aabbss";
        String word1 = "zzazicgvzwntnneauziwfzlrzkynzschzdkbmpqbolwgvxjava", word2 = "uequrwuzhaudmnuqjuolkeszcyfqzqizrdrxpuvuygytbucwog";
        boolean b = solution1657.closeStrings(word1, word2);
        System.out.println(b);
    }

    public boolean closeStrings1(String word1, String word2) {
        if (word2.length() != word1.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        List<Character> list2 = new ArrayList<>();
        for (Character c : charArray1) {
            int i = map1.getOrDefault(c, 0) + 1;
            map1.put(c, i);
        }
        for (Character c : charArray2) {
            int i = map2.getOrDefault(c, 0) + 1;
            map2.put(c, i);
            list2.add(c);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        boolean b = map1.entrySet().stream().anyMatch(x -> map2.get(x.getKey()) == null);
        if (b) {
            return false;
        }
        b = map2.entrySet().stream().anyMatch(x -> map1.get(x.getKey()) == null);
        if (b) {
            return false;
        }
        List<Integer> collect1 = map1.values().stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        List<Integer> collect2 = map2.values().stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        for (int i = 0; i < collect2.size(); i++) {
            if (!collect1.get(i).equals(collect2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        if (word2.length() != word1.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        List<Character> list2 = new ArrayList<>();
        for (Character c : charArray1) {
            int i = map1.getOrDefault(c, 0) + 1;
            map1.put(c, i);
        }
        for (Character c : charArray2) {
            int i = map2.getOrDefault(c, 0) + 1;
            map2.put(c, i);
            list2.add(c);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        boolean b = map1.entrySet().stream().anyMatch(x -> map2.get(x.getKey()) == null);
        if (b) {
            return false;
        }
        b = map2.entrySet().stream().anyMatch(x -> map1.get(x.getKey()) == null);
        if (b) {
            return false;
        }

        List<Character[]> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Integer> x : map2.entrySet()) {
            Integer i = map1.get(x.getKey());
            Integer value = x.getValue();
            if (!value.equals(i)) {
                Map.Entry<Character, Integer> entry = map1.entrySet().stream().filter(z -> {
                    return z.getValue().equals(value) && !z.getKey().equals(x.getKey()) && !set.contains(z.getKey());
                }).findFirst().orElse(null);
                if (entry == null) {
                    return false;
                }
                Character key = entry.getKey();
                Integer value1 = entry.getValue();
                map1.put(x.getKey(), value1);
                map1.put(key, i);
                list.add(new Character[]{x.getKey(), key});
            }
            set.add(x.getKey());
        }
        for (Character[] characters : list) {
            Character character1 = characters[0];
            Character character2 = characters[1];
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : word1.toCharArray()) {
                if (c.equals(character1)) {
                    stringBuilder.append(character2);
                } else if (c.equals(character2)) {
                    stringBuilder.append(character1);
                } else {
                    stringBuilder.append(c);
                }
            }
            word1 = stringBuilder.toString();
        }
        List<Character> list1 = new ArrayList<>();
        for (Character c : word1.toCharArray()) {
            list1.add(c);
        }

        return check(list1, list2);
    }

    private boolean check(List<Character> list1, List<Character> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                Character c = list1.get(i);
                boolean flag = false;
                for (int j = i + 1; j < list2.size(); j++) {
                    if (!Objects.equals(list2.get(j), list1.get(j)) && c.equals(list2.get(j))) {
                        Collections.swap(list2, i, j);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
