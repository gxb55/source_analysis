package com.trip.algorithm.leet.l24.l03;

/**
 * @author xbguo
 * @date 2024/3/13 19:55
 * @description TODO
 */
public class Solution2864 {
    public static void main(String[] args) {

    }
    public String maximumOddBinaryNumber(String s) {
        int x=0;
        char[] charArray = s.toCharArray();
        for (Character c:charArray){
            if(c=='1'){
                x++;
            }
        }
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < x-1; i++) {
            stringBuilder.append("1");
        }
        for (int i = x; i < s.length(); i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append("1");
        return stringBuilder.toString();
    }
}
