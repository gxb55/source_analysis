package com.trip.algorithm.codethink.map;

/**
 * @auther: xbguo
 * @date: 2022/11/7 19:02
 * @description: Solution242
 */
public class Solution242 {
    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        String s = "anagram", t = "nagarm";
        boolean anagram = solution242.isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            arr[index] = arr[index] + 1;
        }
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            int index = chars1[i] - 'a';
            arr[index] = arr[index] - 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
