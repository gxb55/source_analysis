package com.trip.algorithm.codethink.stringcode;

/**
 * @author xbguo
 * @date 2022/11/10 19:05
 * @description Solution344
 */
public class Solution344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int begin = 0;
        int end = s.length - 1;
        while (begin <= end) {
            Character character = s[begin];
            char cha = s[end];
            s[begin] = cha;
            s[end] = character;
        }
    }
}
