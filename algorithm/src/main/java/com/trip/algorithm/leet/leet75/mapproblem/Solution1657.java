package com.trip.algorithm.leet.leet75.mapproblem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年08月13日 11:26:00
 */
public class Solution1657 {
    public static void main(String[] args) {
        Solution1657 solution1657 = new Solution1657();
        String word1 = "abc", word2 = "bca";
        boolean b = solution1657.closeStrings(word1,word2);
        System.out.println(b);
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character,Integer> map1= new HashMap<>();
        Map<Character,Integer> map2= new HashMap<>();
        char[] chars = word1.toCharArray();
        for (Character character:chars){
            Integer orDefault = map1.getOrDefault(character, 0);
            map1.put(character,orDefault+1);
        }
        char[] chars1 = word2.toCharArray();
        for (Character character:chars1){
            Integer orDefault = map2.getOrDefault(character, 0);
            map2.put(character,orDefault+1);
            if(!map1.containsKey(character)){
                return false;
            }
        }

        List<Integer> collect1 = map1.values().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());
        List<Integer> collect2 = map2.values().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());
        if(collect1.size()!=collect2.size()){
            return false;
        }
        for (int i = 0; i < collect2.size(); i++) {
            if(!Objects.equals(collect1.get(i), collect2.get(i))){
                return false;
            }
        }
        return true;
    }
}
