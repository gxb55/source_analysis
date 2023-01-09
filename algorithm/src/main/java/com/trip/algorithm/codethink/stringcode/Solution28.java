package com.trip.algorithm.codethink.stringcode;

/**
 * @author xbguo
 * @date 2022/11/11 15:01
 * @description Solution28
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * 通过次数762,704提交次数1,827,161
 */
public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        //   String haystack = "sadbutsad", needle = "sad";
        //    String haystack = "leetcode", needle = "leeto";
        // String haystack = "mississippi", needle = "issip";
        String haystack = "leetcode", needle = "leeto";
      //  String haystack = "mississippi", needle = "pi";
        int i = solution28.strStr1(haystack, needle);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int length = haystack.length();
        int len = needle.length();
        int[] dp = new int[length];
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        if (chars1[0] == chars[0]) {
            dp[0] = 1;
            if (dp[0] == len) {
                return 0;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] != 0) {
                dp[i] = chars[i] == chars1[dp[i - 1]] ? dp[i - 1] + 1 : 0;
            }
            if (dp[i] == 0) {
                dp[i] = chars[i] == chars1[0] ? 1 : 0;
            }
            if (dp[i] == len) {
                return i - len + 1;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int index = 0;
        int index1 = 0;
        int curIndex = 0;
        while (true) {
            if (chars[index] == chars1[index1]) {
                index1++;
                index++;
                if (curIndex == 0) {
                    curIndex = index;
                }
            } else {
                if (curIndex != 0) {
                    index = curIndex;
                    curIndex = 0;
                    index1=0;
                } else {
                    index++;
                    index1 = 0;
                }
            }
            if (index1 == (needle.length())) {
                return index - needle.length();
            }
            if (index >= haystack.length()) {
                return -1;
            }
        }

    }


    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i<s.length(); i++){
            while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }

            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public int strStr2(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i<haystack.length();i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }
}
