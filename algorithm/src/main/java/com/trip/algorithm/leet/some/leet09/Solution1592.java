package com.trip.algorithm.leet.some.leet09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/9/7  15:44
 * @description Solution1592
 */
public class Solution1592 {
    public static void main(String[] args) {
        Solution1592 solution1592 = new Solution1592();
     //   String text = "  this   is  a sentence ";
       // String text = "a";
        String text = "  hello";
        String s = solution1592.reorderSpaces(text);
        System.out.println(s);
    }

    public String reorderSpaces(String text) {
        int len = 0;
        int len1 = 0;
        List<String> list = new ArrayList<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (chars[i] == ' ') {
                while (i < text.length() && chars[i] == ' ') {
                    len++;
                    i++;
                }
            } else {
                len1++;
                StringBuilder stringBuilder = new StringBuilder();
                while (i < text.length() && chars[i] != ' ') {
                    stringBuilder.append(chars[i]);
                    i++;
                }
                list.add(stringBuilder.toString());
            }
            i--;
        }
        if(len==0){
            return text;
        }else if(len1==1){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list.get(0));
            for (int k = 0; k < len; k++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
        int i = len / (len1 - 1);
        int res = len - i * (len1 - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < len1; j++) {
            stringBuilder.append(list.get(j));
            if (j != (len1 - 1)) {
                for (int k = 0; k < i; k++) {
                    stringBuilder.append(" ");
                }
            } else {
                for (int k = 0; k < res; k++) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
