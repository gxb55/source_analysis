package com.trip.algorithm.leet.leet75.slidewindowproblem;

/**
 * @author xbguo
 * @createTime 2023年08月25日 22:10:00
 */
public class Solution1456 {
    public static void main(String[] args) {

        Solution1456 solution1456 = new Solution1456();
       /* String s = "abciiidef";
        int k = 3;  */

        String s = "aeiou";
        int k = 2;
        int i = solution1456.maxVowels(s, k);
        System.out.println(i);
    }

    public int maxVowels(String s, int k) {
        int count = 0;
        char[] chars1 = s.toCharArray();
        int left = 0;
        int max = 0;
        for (int i = 0; i < chars1.length; i++) {
            char c = chars1[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            if ((i - left) >= k) {
                char c1 = chars1[left];
                if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                    count--;
                }
                left++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
