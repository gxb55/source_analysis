package com.trip.algorithm.leet.l24.l06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/6/17 19:31
 */
public class Solution521 {
    public static void main(String[] args) {
        String a="aefawfawfawfaw";
        String b="aefawfeawfwafwaef";
        Solution521 solution521 =new Solution521();
        int luSlength = solution521.findLUSlength(a,b);
        System.out.println(luSlength);
    }
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
    
        return Math.max(a.length(),b.length());
    }

    private void process(Map<String, Integer> map, String str, int i, LinkedList<Character> characters) {
        if (i >= str.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : characters) {
                stringBuilder.append(c);
            }
            String string = stringBuilder.toString();
            Integer v = map.getOrDefault(string, 0);
            map.put(string, v + 1);
            return;
        }
        for (int j = i; j < str.length(); j++) {
            char c = str.charAt(j);
            characters.addLast(c);
            process(map,str,j+1,characters);

            characters.pollLast();
            process(map,str,j+1,characters);
        }
    }
}

