package com.trip.algorithm.leet.some.Leet2308;

/**
 * @author xbguo
 * @date 2023/8/9 16:59
 */
public class Solution344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        Character character = null;
        while (left < right) {
            character = s[left];
            s[left] = s[right];
            s[right] = character;
            left++;
            right--;
        }
    }
}
