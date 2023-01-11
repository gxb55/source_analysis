package com.trip.algorithm.leet.some.other;

/**
 * @author xbguo
 * @date 2022/11/17 16:32
 * @description 580
 * 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class Solution680 {
    public static void main(String[] args) {
        Solution680 solution680 = new Solution680();
       // String s = "aba";
      //  String s = "abca";
        String s = "abc";
        boolean b = solution680.validPalindrome(s);
        System.out.println(b);
    }

    public boolean validPalindrome(String s) {
        StringBuilder stringBuilder2 = new StringBuilder(s);
        if(s.equals(stringBuilder2.reverse().toString())){
            return true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if ((left <= right)) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (i != left) {
                    stringBuilder.append(chars[i]);
                }
                if (i != right) {
                    stringBuilder1.append(chars[i]);
                }
            }
            return stringBuilder1.toString().equals(stringBuilder1.reverse().toString()) || stringBuilder.toString().equals(stringBuilder.reverse().toString());
        }
            return true;
    }
}
