package com.trip.algorithm.leet.leet75.bitoperationproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/8/17 13:57
 */
public class Solution338 {
    public static void main(String[] args) {
        int x = 5;
        int[] ints = countBits2(x);
        System.out.println(Arrays.toString(ints));


        System.out.println(decimalToBinary(36));
        System.out.println(Integer.toBinaryString(36));
    }

    public static String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal = decimal / 2;
        }
        return binary;
    }


    public static int[] countBits2(int n) {
        int[] res = new int[n + 1];
        if (n == 0) {
            res[0] = 0;
            return res;
        }
        for (int i = 1; i <= n; i++) {
            int cur = i;
            int count = 0;
            while (cur > 0) {
                int k = cur % 2;
                cur = cur / 2;
                if (k == 1) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static int[] countBits1(int n) {
        String s = "0";
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            Character pre = '1';
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == '1' && pre == '1') {
                    pre = '1';
                    stringBuilder.append('0');
                } else if (aChar == '1' || pre == '1') {
                    stringBuilder.append('1');
                    pre = '0';
                } else if (pre == '0') {
                    stringBuilder.append(aChar);
                }
            }
            if (pre == '1') {
                stringBuilder.append('1');
            }
            s = stringBuilder.toString();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }


    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
