package com.trip.algorithm.leet.some.leet08;

/**
 * @author xbguo
 * @date 2022/8/18  20:16
 * @description TODO
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int x=-515;
        boolean palindrome = solution9.isPalindrome(x);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
