package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/16 10:03
 */
public class Solution1177 {
    public static void main(String[] args) {
        Solution1177 solution1177 = new Solution1177();
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};

    /*    String s = "hunu";
        int[][] queries = {{0, 3, 1}};*/

        List<Boolean> list = solution1177.canMakePaliQueries(s, queries);
        System.out.println(list);
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Map<Character,Integer>> mapList = new ArrayList<>();
        for (int i=0;i<chars.length;i++){
            char aChar = chars[i];
            if(i==0){
                Map<Character,Integer> map = new HashMap<>();
                map.put(aChar,1);
                mapList.add(map);
            }else{
                Map<Character,Integer> map = new HashMap<>();
                map.putAll(mapList.get(i - 1));
                map.put(aChar,map.getOrDefault(aChar,0)+1);
                mapList.add(map);
            }
        }
        for (int[] ar : queries) {
            boolean res = check(chars, ar[0], ar[1], ar[2],mapList);
            list.add(res);
        }
        return list;
    }

    private boolean check(char[] chars, int left, int right, int i, List<Map<Character, Integer>> mapList) {
        Map<Character, Integer> map1 = left - 1 == -1 ? new HashMap<>() : mapList.get(left - 1);
        Map<Character, Integer> map2 =  mapList.get(right);

        Map<Character, Integer> map = new HashMap<>();
        for (Map.Entry<Character,Integer> entry:map2.entrySet()){
            Integer value = entry.getValue();
            Character key = entry.getKey();
            int res=value-map1.getOrDefault(key,0);
            res = res % 2;
            if (res != 0) {
                map.put(key, res);
            }
        }
        int size = map.size();
        if (size <= i) {
            return true;
        }
        int i1 = size / 2;
        return i >= i1;
    }


}
