package com.trip.algorithm.leet.l24.l100;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        List<Character> list = new LinkedList();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (list.contains(c)) {
                int i1 = list.indexOf(c);
                res = Math.max(res, list.size());
                for (int j = 0; j <= i1; j++) {
                    list.remove(0);
                }
            }
            list.add(c);
        }
        res = Math.max(res, list.size());
        return res;
    }
}
