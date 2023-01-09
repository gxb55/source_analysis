package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2023/1/3 09:48
 */
public class Solution2042 {
    public static void main(String[] args) {
        Solution2042 solution2042 = new Solution2042();
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
         s = "4 5 11 26";
         s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        boolean b = solution2042.areNumbersAscending(s);
        System.out.println(b);
    }

    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int last = -1;
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            char[] chars = s2.toCharArray();
            boolean flag = true;
            for (Character character : chars) {
                if (character < '0' || character > '9') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Integer integer = Integer.valueOf(s2);
                if (last == -1) {
                    last = integer;
                } else {
                    if (integer <= last) {
                        return false;
                    }
                    last = integer;
                }
            }
        }
        return true;
    }
}
