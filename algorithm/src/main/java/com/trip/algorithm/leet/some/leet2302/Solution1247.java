package com.trip.algorithm.leet.some.leet2302;

/**
 * @author xbguo
 * @createTime 2023年02月25日 09:57:00
 */
public class Solution1247 {
    public static void main(String[] args) {
        String s1 = "xx", s2 = "yy";
        // String s1 = "xy", s2 = "yx";
        int i = minimumSwap(s1, s2);
        System.out.println(i);
    }

    public static int minimumSwap(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        char[] chars = s1.toCharArray();
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = s1.charAt(i);
            char z = s2.charAt(i);
            if (c != z) {
                if (c == 'x') {
                    xy++;
                } else {
                    yx++;
                }
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + yx % 2 + yx % 2;
    }
}
