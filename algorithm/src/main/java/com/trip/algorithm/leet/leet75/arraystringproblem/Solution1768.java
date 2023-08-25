package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @date 2023/8/25 15:02
 */
public class Solution1768 {
    public static void main(String[] args) {

    }
    public String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int i=0;
        int j=0;
        StringBuilder stringBuilder =new StringBuilder();
        while (i<chars1.length||j<chars2.length){
            if(i<chars1.length){
                stringBuilder.append(chars1[i]);
                i++;
            }
            if(j<chars2.length){
                stringBuilder.append(chars2[j]);
                j++;
            }
        }
        return stringBuilder.toString();
    }
}
