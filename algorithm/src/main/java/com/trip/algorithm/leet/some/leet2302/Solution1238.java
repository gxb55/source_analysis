package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年02月23日 07:07:00
 */
public class Solution1238 {
    public static void main(String[] args) {

        int n = 2, start = 3;
        List<Integer> list = Solution1238.circularPermutation(n, start);
        System.out.println(list);
    }

    public static List<Integer> circularPermutation(int n, int start) {
        double pow = Math.pow(2, n);
        String s = Integer.toBinaryString(start);
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '1' && flag) {
                stringBuilder.append(0);
                flag = false;
            } else {
                stringBuilder.append(aChar);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pow; i++) {
            if (i % 2 == 0) {
                list.add(s);
            } else {
                list.add(stringBuilder.toString());
            }
        }
        List<Integer> collect = list.stream().map(x -> Integer.parseInt(x,2)).collect(Collectors.toList());
        return collect;
    }
}
