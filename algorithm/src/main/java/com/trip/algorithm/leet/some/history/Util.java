package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年04月30日 16:54:00
 */
public class Util {
    public static int[] getArr(String s) {
        String[] split = s.substring(1, s.length() - 1).split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.valueOf(split[i]);
        }
        return result;
    }
}
