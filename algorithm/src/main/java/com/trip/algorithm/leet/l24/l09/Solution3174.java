package com.trip.algorithm.leet.l24.l09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/9/5 14:20
 */
public class Solution3174 {
    public static void main(String[] args) {

    }

    public String clearDigits(String s) {
        char[] charArray = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
