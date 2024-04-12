package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/10 10:13
 */
public class Solution1702 {
    public static void main(String[] args) {
        String binary = "000110";
        binary = "1100";
        String string = maximumBinaryString(binary);
        System.out.println(string);
    }

    public static String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        int len = charArray.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '0') {
                while (j <= i || (j < len && charArray[j] == '1')) {
                   j++;
                }
                if(j<len){
                    charArray[j]='1';
                    charArray[i]='1';
                    charArray[i+1]='0';
                }
            }
        }
        return new String(charArray);
    }
    public static String maximumBinaryString1(String binary) {
        int n = binary.length();
        char[] s = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                while (j <= i || (j < n && s[j] == '1')) {
                    j++;
                }
                if (j < n) {
                    s[j] = '1';
                    s[i] = '1';
                    s[i + 1] = '0';
                }
            }
        }
        return new String(s);
    }
}
