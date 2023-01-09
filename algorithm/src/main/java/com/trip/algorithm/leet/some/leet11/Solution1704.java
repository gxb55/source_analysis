package com.trip.algorithm.leet.some.leet11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/11/11 09:48
 * @description Solution1704
 */
public class Solution1704 {
    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        int left = 0;
        int right = 0;
        int middle = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > middle - 1) {
                if (set.contains(c)) {
                    left++;
                }
            } else {
                if (set.contains(c)) {
                    right++;
                }
            }
        }
        return left == right;
    }
}
