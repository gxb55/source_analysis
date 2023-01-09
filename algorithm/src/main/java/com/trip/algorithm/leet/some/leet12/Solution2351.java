package com.trip.algorithm.leet.some.leet12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/3 18:23
 * @description TODO
 */
public class Solution2351 {
    public static void main(String[] args) {

    }

    public char repeatedCharacter(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(map.containsKey(aChar)){
                return aChar;
            }else{
                map.put(aChar,1);
            }
        }
        return 'z';
    }
}
