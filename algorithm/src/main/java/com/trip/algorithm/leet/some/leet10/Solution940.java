package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/14 09:52
 * @description: Solution940
 */
public class Solution940 {
    public static void main(String[] args) {

    }

    Integer count = 0;

    public int distinctSubseqII(String s) {
        char[] chars = s.toCharArray();
        process(chars,0);
        return count;
    }

    private void process(char[] chars, int i) {

    }
}
