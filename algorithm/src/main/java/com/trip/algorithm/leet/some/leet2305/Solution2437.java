package com.trip.algorithm.leet.some.leet2305;

/**
 * @author xbguo
 * @createTime 2023年05月10日 21:44:00
 */
public class Solution2437 {
    public static void main(String[] args) {
        String time="?5:00";
         time="0?:0?";
         time="??:??";
        int i = countTime(time);
        System.out.println(i);
    }

    public static int countTime(String time) {
        String[] split = time.split(":");
        Integer x = 1;
        Integer y = 1;
        if (split[0].charAt(0) == '2') {
            if (split[0].charAt(1) == '?') {
                x = 4;
            }
        } else if (split[0].charAt(0) == '?') {
            if (split[0].charAt(1) == '?') {
                x = 24;
            } else if (split[0].charAt(1) >= '0' && split[0].charAt(1) <= '3') {
                x = 3;
            } else {
                x = 2;
            }
        } else {
            //0 1
            if (split[0].charAt(1) == '?') {
                x = 10;
            }
        }

        if (split[1].charAt(0) == '?') {
            y = y * 6;
        }
        if (split[1].charAt(1) == '?') {
            y = y * 10;
        }
        return x * y;
    }
}
