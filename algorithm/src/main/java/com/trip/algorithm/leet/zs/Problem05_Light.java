package com.trip.algorithm.leet.zs;

/**
 * @author xbguo
 * @createTime 2022年07月03日 20:43:00
 */
public class Problem05_Light {
    public static void main(String[] args) {
        String str="XXX...X.X.X..X..X...X";
        int i = minLight(str);
        System.out.println(i);
    }

    public static int minLight(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'X') {
                continue;
            }
            if (aChar == '.' && (i + 1) < chars.length) {
                if (chars[i + 1] == '.') {
                    res++;
                    i++;
                    i++;
                } else if (chars[i + 1] == 'X') {
                    res++;
                    i++;
                }
            } else {
                res++;
            }
        }
        return res;
    }
}
