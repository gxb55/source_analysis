package com.trip.algorithm.leet.l24.l08;

public class Solution551 {
    public static void main(String[] args) {

    }

    public boolean checkRecord(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'A') {
                count++;
            }
            if (c == 'L') {
                int t = 0;
                while (i < charArray.length && charArray[i] == 'L') {
                    i++;
                    t++;
                }
                max = Math.max(max, t);
                i--;
                if (max >= 3) {
                    return false;
                }
            }
        }
        return count<2;
    }

}
