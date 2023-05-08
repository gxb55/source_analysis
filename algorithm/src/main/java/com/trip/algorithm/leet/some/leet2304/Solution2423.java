package com.trip.algorithm.leet.some.leet2304;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年04月29日 21:44:00
 */
public class Solution2423 {
    public static void main(String[] args) {
        String word = "abcc";
        word = "aazz";
        word = "abbcc";
        //   word = "cbccca";
        boolean b = equalFrequency(word);
        System.out.println(b);
    }

    public static boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            map.put(aChar,map.get(aChar)-1);
            boolean flag =false;
            if(map.get(aChar)==0){
                flag=true;
                map.remove(aChar);
            }

            if(map.values().stream().distinct().collect(Collectors.toList()).size()==1){
                return true;
            }
            if(flag){
                map.put(aChar,1);
            }else{
                map.put(aChar,map.get(aChar)+1);
            }
        }
        return false;
    }
}
