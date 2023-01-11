package com.trip.algorithm.codethink.stringcode;


/**
 * @author xbguo
 * @date 2022/11/10 19:10
 * @description Solution541
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class Solution541 {
    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
       /* String s1 = "abcdefg";
        int k = 2;*/

        String s1 = "abcd";
        int k = 2;
        String s = solution541.reverseStr(s1, k);
        System.out.println(s);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int begin = 0;
        while (begin < s.length()) {
            if (begin + k >= s.length()) {
                int end = s.length()-1;
                while (begin <= end) {
                    Character characters = chars[begin];
                    chars[begin] = chars[end];
                    chars[end] = characters;
                    begin++;
                    end--;
                }
                break;
            } else {
                int curBegin = begin;
                int end = begin + k-1;
                while (begin <= end) {
                    Character characters = chars[begin];
                    chars[begin] = chars[end];
                    chars[end] = characters;
                    begin++;
                    end--;
                }
                begin = curBegin + 2 * k;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character:chars){
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
