package com.trip.algorithm.leet.l24.l09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/9/24 19:17
 */
public class Solution2207 {
    public static void main(String[] args) {
        //     String text = "abdcdbc", pattern = "ac";
        // String text = "aabb", pattern = "ab";
        String text = "fwymvreuftzgrcrxczjacqovduqaiig", pattern = "yy";
        long l = maximumSubsequenceCount(text, pattern);
        System.out.println(l);
    }

    public static long maximumSubsequenceCount(String text, String pattern) {
        char[] charArray = text.toCharArray();
        char[] charArray1 = pattern.toCharArray();
        Character a = charArray1[0];
        Character b = charArray1[1];
        List<Character> list = new ArrayList<>();
        int leftA = 0;
        int rightB = 0;
        for (Character c : charArray) {
            if (c == a || c == b) {
                list.add(c);
            }
            if (c == b) {
                rightB++;
            }
        }
        long max = 0;
        long count = 0;
        int t = rightB;
        for (Character c : list) {
            if (c == a) {
                leftA++;
            }
            if (c == b) {
                rightB--;
            }

            if (c == a) {
                count += rightB;
            } else {

            }

        }
        rightB = t;
        max = Math.max(max, rightB);
        max = Math.max(max, leftA);

        return count + max;
    }
}
