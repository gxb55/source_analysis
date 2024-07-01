package com.trip.algorithm.leet.l24.l06;

public class Solution2710 {
    public static void main(String[] args) {
        String str = "123000";
        String string = removeTrailingZeros(str);
        System.out.println(string);
    }

    public static String removeTrailingZeros(String num) {
        char[] charArray = num.toCharArray();
        int index = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '0') {
                index++;
            } else {
                break;
            }
        }
        return num.substring(0, charArray.length - index );
    }
}
