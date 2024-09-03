package com.trip.algorithm.leet.l24.l08;

import java.util.HashMap;
import java.util.Map;

public class Solution3146 {
    public static void main(String[] args) {

    }

    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }
        char[] charArray1 = t.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray1.length; i++) {
            Integer i1 = map.get(charArray1[i]);
            res = res + Math.abs(i - i1);
        }
        return res;
    }
}
