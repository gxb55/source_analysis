package com.trip.algorithm.leet.some.leet2301;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年01月16日 08:21:00
 */
public class Solution1813 {
    public static void main(String[] args) {
        Solution1813 solution1813 = new Solution1813();
        String sentence1 = "My name is Haley1", sentence2 = "My Haley";
        boolean b = solution1813.areSentencesSimilar(sentence1, sentence2);
        System.out.println(b);
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            String str = sentence1;
            sentence1 = sentence2;
            sentence2 = str;
        }
        // 由 sentence1 ->sentence2
        if (sentence2.contains(sentence1)) {
            if (sentence2.startsWith(sentence1 + " ")) {
                return true;
            } else if (sentence2.endsWith(" " + sentence1)) {
                return true;
            }
        }

        List<String> list1 = Arrays.stream(sentence1.split(" ")).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(sentence2.split(" ")).collect(Collectors.toList());
        boolean flag = false;
        int i = 0;
        int j = 0;
        flag1:
        for (i = 0; i < list2.size(); i++) {
            String s = list2.get(i);
            for (j = 0; j < list1.size(); j++) {
                String s1 = list1.get(j);
                if (flag) {
                    if (!s1.equals(s)) {
                        break flag1;
                    }
                } else {
                    if (s.equals(s1)) {
                        flag = true;
                    }
                }
            }
        }
        boolean flag2 = false;
         i = list2.size()-1;
         j = list1.size()-1;
        flag3:
        for (; i >= 0; i--) {
            String s = list2.get(i);
            for (; j >= 0; j--) {
                String s1 = list1.get(j);
                if (flag2) {
                    if (!s1.equals(s)) {
                       break flag3;
                    }
                } else {
                    if (s.equals(s1)) {
                        flag2 = true;
                    }
                }
            }
        }
        return flag2&&flag;
    }
}
