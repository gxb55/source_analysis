package com.trip.algorithm.leet.some.leet2304;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年04月09日 07:37:00
 */
public class Solution2399 {
    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);

      /*  String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
*/
        String s = "aa";
        int[] distance = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean b = checkDistances(s, distance);
        System.out.println(b);
    }

    public static boolean checkDistances(String s, int[] distance) {
        char[] chars = s.toCharArray();
        int[] arr = new int[26];
        int[] st = new int[26];
        Arrays.fill(st, -1);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int v = aChar - 97;
            if (st[v] == -1) {
                st[v] = 0;
                arr[v] = i;
            } else if (st[v] == 0) {
                st[v] = 1;
                arr[v] = i - arr[v] - 1;
            }
        }
        for (int i = 0; i < st.length; i++) {
            if (st[i] == 1) {
                if (i >= distance.length) {
                    return false;
                }
                if (arr[i] != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
