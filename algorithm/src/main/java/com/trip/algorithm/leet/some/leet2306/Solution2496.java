package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @date 2023/6/25 15:40
 */
public class Solution2496 {
    public static void main(String[] args) {

        String s = "11";
        boolean matches = s.matches("\\d*");
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        int i = maximumValue(strs);
        System.out.println(i);
    }

    public static int maximumValue(String[] strs) {
        int max = 0;
        for (String x : strs) {
            if (x.matches("\\d+")) {
                while (x.startsWith("0")) {
                    x = x.substring(1, x.length());
                }
                if (x.length() > 0) {
                    max = Math.max(max, Integer.valueOf(x));
                }
            } else {
                max = Math.max(max, x.length());
            }
        }
        return max;
    }
}
