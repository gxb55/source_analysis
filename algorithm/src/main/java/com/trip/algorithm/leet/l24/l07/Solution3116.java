package com.trip.algorithm.leet.l24.l07;

public class Solution3116 {
    public static void main(String[] args) {
        String s = "kb";
        int k = 16;
        String smallestString = getSmallestString(s, k);
        System.out.println(smallestString);
    }

    public static String getSmallestString(String s, int k) {
        char[] charArray = s.toCharArray();
        char[] chars = new char[s.length()];
        for (int i = 0; i < charArray.length; i++) {
            chars[i] = charArray[i];
        }
        //97 122
        for (int i = 0; i < charArray.length && k > 0; i++) {
            char cur = charArray[i];
            int leftLen = cur - 'a';
            int rightLen = 'z' - cur + 1;
            if (k < leftLen && k < rightLen) {
                chars[i] = (char) (cur - k);
                k = 0;
            } else if (k >= leftLen && k >= rightLen) {
                chars[i] = 'a';
                k -= Math.min(leftLen, rightLen);
            } else if (k >= leftLen && k < rightLen) {
                chars[i] = 'a';
                k -= leftLen;
            } else if (k < leftLen && k >= rightLen) {
                chars[i] = 'a';
                k -= rightLen;
            }
        }
        return new String(chars);
    }

    @Override
    public String toString() {
        return "Solution3116{}";
    }
}
