package com.trip.algorithm.leet.some.leet2310;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年10月30日 21:55:00
 */
public class Solution127 {
    public static void main(String[] args) {
        Solution127 solution127 = new Solution127();
       /* String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};*/

        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","tog","cog"};


       /* String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log"};*/
       /* String beginWord = "hot", endWord = "dog";
        String[] wordList = {"hot", "dog"};*/

      /*  String beginWord = "qa", endWord = "sq";
        String[] wordList = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb",
                "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to",
                "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or",
                "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
                "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi"
                , "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
                "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
                "ni", "mr", "pa", "he", "lr", "sq", "ye"};*/
        System.out.println(wordList.length);


        int i = solution127.ladderLength(beginWord, endWord, List.of(wordList));
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        this.endWord = endWord;
        wordList = wordList.stream().filter(x -> x.length() == beginWord.length()).collect(Collectors.toList());
        wordList.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String x = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String y = wordList.get(j);
                boolean flag = check(x, y);
                if (flag) {
                    List<String> orDefault = map.getOrDefault(x, new ArrayList<>());
                    orDefault.add(y);
                    map.put(x, orDefault);

                    List<String> orDefault1 = map.getOrDefault(y, new ArrayList<>());
                    orDefault1.add(x);
                    map.put(y, orDefault1);
                }
            }
        }
        List<String> list = new ArrayList<>();

        Set<String> set = new HashSet<>();
        List<String> list1 = map.get(beginWord);
        if (list1 == null) {
            return 0;
        }
        int count = 0;
        set.addAll(list1);
        while (list1.size() != 0) {
            count++;
            if (list1.contains(endWord)) {
                count++;
                return count;
            }
            List<String> list2 = new ArrayList<>();
            for (String s : list1) {
                List<String> list3 = map.get(s);
                if (list3 != null) {
                    list3.stream().filter(x -> set.add(x)).forEach(x -> list2.add(x));
                }
            }
            list1 = list2;
        }
        return 0;
    }

    private void process(Map<String, List<String>> map, String beginWord, Set<String> set, List<String> list) {
        if (beginWord.equals(endWord)) {
            System.out.println(list);
            res = Math.min(res, list.size());
            return;
        }
        List<String> list1 = map.get(beginWord);
        if (list1 == null) {
            return;
        }
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            if (list.contains(s)) {
                continue;
            }
            list.add(s);
            process(map, s, set, list);
            list.remove(s);
        }
    }

    int res = Integer.MAX_VALUE;
    String endWord = null;

    private boolean check(String x, String y) {
       /* int abs = Math.abs(x.length() - y.length());
        if (abs > 1) {
            return false;
        }*/
        int len = Math.min(x.length(), y.length());
        char[] charArray = x.toCharArray();
        char[] charArray1 = y.toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (charArray1[i] != charArray[i]) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        if (x.length() == y.length()) {
            return count == 1;
        } else {
            return count == 0;
        }
    }
}
