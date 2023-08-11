package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/9 17:02
 */
public class Solution345 {

    public static void main(String[] args) {
        Solution345 solution345 = new Solution345();
        String t="hello";
        String s = solution345.reverseVowels(t);
        System.out.println(s);
    }
    public String reverseVowels(String s) {
        List<Character> list = Arrays.asList('A','a','E','e','I','i','o','O','u','U');
        char[] chars = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            while (!list.contains(chars[left])&&left<right){
                left++;
            }
            while (!list.contains(chars[right])&&left<right){
                right--;
            }
            if(left<right){
                char aChar = chars[left];
                chars[left]=chars[right];
                chars[right]=aChar;
            }else{
                break;
            }
            left++;
            right--;
        }
        return new String(chars);
    }
}
