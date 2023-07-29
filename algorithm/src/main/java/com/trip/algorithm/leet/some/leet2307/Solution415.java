package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @date 2023/7/17 15:47
 * num1 = "11", num2 = "123"
 */
public class Solution415 {
    public static void main(String[] args) {
        String num1 = "9", num2 = "1";
        String s = addStrings(num1, num2);
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        char[] chars = num2.toCharArray();
        char[] chars1 = num1.toCharArray();
        int index1 = chars1.length - 1;
        int index = chars.length - 1;
        int last=0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index >= 0 || index1 >= 0) {
            Character s1 = '0';
            Character s2 = '0';
            if (index >= 0) {
                s1 = chars[index];
                index--;
            }
            if (index1 >= 0) {
                s2 = chars1[index1];
                index1--;
            }
            int i = s1-'0' + s2-'0'+last;
            stringBuilder.append(i%10);
            last=i/10;
        }
        if(last!=0){
            stringBuilder.append(last);
        }
        return stringBuilder.reverse().toString();

    }
}
