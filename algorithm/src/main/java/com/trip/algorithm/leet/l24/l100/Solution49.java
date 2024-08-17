package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/8/9 16:24
 */
public class Solution49 {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =new HashMap<>();
        for (String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            List<String> orDefault = map.getOrDefault(string, new ArrayList<>());
            orDefault.add(s);
            map.put(string,orDefault);
        }
        List<List<String>> collect = map.values().stream().collect(Collectors.toList());
        return collect;
    }
}
