package com.trip.algorithm.leet.leet75.stackproblem;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2023年08月13日 16:14:00
 */
public class Solution2390 {
    public static void main(String[] args) {
       // String s1 = "leet**cod*e";
        String s1 = "erase*****";
        String s = removeStars(s1);
        System.out.println(s);
    }

    public static String removeStars(String s) {
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (Character character : chars) {
            if (character == '*') {
                if (!list.isEmpty()) {
                    list.pollLast();
                }
            } else {
                list.addLast(character);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
