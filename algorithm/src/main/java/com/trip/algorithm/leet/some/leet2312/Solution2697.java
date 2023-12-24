package com.trip.algorithm.leet.some.leet2312;

public class Solution2697 {
    public static void main(String[] args) {

    }

    public String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int l = 0;
        int r = charArray.length - 1;
        while (l <= r) {
            char a = charArray[l];
            char b = charArray[r];
            if (a != b) {
                char c = a > b ? b : a;
                charArray[l] = c;
                charArray[r] = c;
            }
            l++;
            r--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character str : charArray) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
