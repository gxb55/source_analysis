package com.trip.algorithm.leet.l24.l06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/6/17 19:18
 */
public class Solution522 {
    public static void main(String[] args) {
        Solution522 solution522 =new Solution522();
        String[] arr={"aba","cdc","eae"};
        int luSlength = solution522.findLUSlength(arr);
        System.out.println(luSlength);
    }

    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            process(map, str, 0, new LinkedList<Character>());
        }
        Map.Entry<String, Integer> stringIntegerEntry = map.entrySet().stream().filter(x -> x.getValue() == 1).sorted((x, y) -> y.getKey().length() - x.getKey().length()).findFirst().orElse(null);
        if(stringIntegerEntry!=null){
            return stringIntegerEntry.getKey().length();
        }
        return -1;
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
