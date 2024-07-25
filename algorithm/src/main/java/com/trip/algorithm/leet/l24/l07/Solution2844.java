package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/25 19:23
 */
public class Solution2844 {

    public static void main(String[] args) {

    }

    public int minimumOperations(String num) {
//  25 75 50 00
        int s1 = 0;
        int s2 = 0;
        int i = num.length();
        char[] charArray = num.toCharArray();
        while (i >= 0 && charArray[i] != '0') {
            i--;
        }

        int j = i - 1;
        while (j >= 0 && charArray[j] != '0' && charArray[j] != '5') {
            j--;
        }
        if (j >= 0) {
            s1 = num.length() - j;
        }

         i = num.length();
        while (i >= 0 && charArray[i] != '5') {
            i--;
        }

        j = i - 1;
        while (j >= 0 && charArray[j] != '2' && charArray[j] != '7') {
            j--;
        }
        if (j >= 0) {
            s1 = num.length() - j;
        }

        return Math.min(s2,s1);
    }
}
