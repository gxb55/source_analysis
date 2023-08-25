package com.trip.algorithm.leet.leet75.arraystringproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月22日 21:47:00
 */
public class Solution151 {
    public static void main(String[] args) {
       String s1 = "   the sky  is blue ";
        s1 = "  hello world  ";
        String s = reverseWords(s1);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Boolean fistFlag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && fistFlag) {

            } else if (c == ' ') {
                fistFlag = false;
                if (stringBuilder.length() > 0) {
                    list.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            } else {
                stringBuilder.append(c);
                fistFlag = false;
            }
        }
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
        StringBuilder res = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            res.append(list.get(j));
            if (j != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
