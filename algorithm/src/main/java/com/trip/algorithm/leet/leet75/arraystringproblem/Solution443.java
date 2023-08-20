package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @createTime 2023年08月20日 22:20:00
 */
public class Solution443 {
    public static void main(String[] args) {
       // char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a'};
      //  char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(compress);

    }

    public static int compress(char[] chars) {
        Character last = null;
        int count = -1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (last == null) {
                last = aChar;
                count = 1;
            } else if (last != aChar) {
                stringBuilder.append(last).append(count);
                last = aChar;
                count = 1;
            }else if(last==aChar){
                count++;
            }
        }
        stringBuilder.append(last).append(count);
        return stringBuilder.length();
    }
}
