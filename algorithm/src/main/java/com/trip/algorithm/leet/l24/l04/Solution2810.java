package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/1 18:30
 */
public class Solution2810 {
    public static void main(String[] args) {

    }
    public String finalString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c=='i'){
                StringBuilder reverse = stringBuilder.reverse();
                stringBuilder=new StringBuilder();
                stringBuilder.append(reverse.toString());

            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
