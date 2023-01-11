package com.trip.algorithm.leet.some.history;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/21  10:33
 * @description 824
 */
public class Solution824 {
    public static void main(String[] args) {
        Solution824 solution824 = new Solution824();
        String s = solution824.toGoatLatin("I speak Goat Latin");
        System.out.println(s);
    }
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String[] s = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if(set.contains(s1.charAt(0))){
                stringBuilder.append(s1);
            }else{
                stringBuilder.append(s1.substring(1)).append(s1.charAt(0));
            }
            stringBuilder.append("ma");
            for (int j = -1; j < i; j++) {
                stringBuilder.append("a");
            }
            if(i!=s.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
