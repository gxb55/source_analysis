package com.trip.algorithm.leet.l24.l06;

public class Solution2734 {
    public static void main(String[] args) {
        String str="aa";
        String string = smallestString(str);
        System.out.println(string);
    }

    public static String smallestString(String s) {

        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        boolean allZero=true;
        for (char c : charArray) {
            if (c != 'a') {
                allZero=false;
            }
            if (flag==0) {
                if (c == 'a') {
                    stringBuilder.append(c);
                } else {
                    flag = 1;
                    char t = (char) (c - 1);
                    stringBuilder.append(t);
                }
            } else if(flag==1) {
                if (c == 'a') {
                    stringBuilder.append(c);
                    flag=2;
                } else {
                    char t = (char) (c - 1);
                    stringBuilder.append(t);
                }
            }else {
                stringBuilder.append(c);
            }
        }
        if(allZero){
            stringBuilder.setCharAt(stringBuilder.length()-1,'z');
        }
        return stringBuilder.toString();
    }
}
