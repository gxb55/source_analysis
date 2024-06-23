package com.trip.algorithm.leet.l24.l06;

public class Solution520 {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {
        char[] charArray = word.toCharArray();
        // 全大写
        boolean p1 = true;
        // 全小写
        boolean p2 = true;
        // 首字符大写
        boolean p3 = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'A' && c <= 'Z') {
                p2 = false;
            }
            if (c >= 'a' && c <= 'z') {
                p1 = false;
            }
            if (i == 0) {
                if (c >= 'a' && c <= 'z') {
                    p3 = false;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    p3 = false;
                }
            }
            if (p1 || p2 || p3) {

            } else {
                return false;
            }
        }
        return true;
    }
}
