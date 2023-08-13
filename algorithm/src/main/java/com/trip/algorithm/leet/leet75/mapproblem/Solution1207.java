package com.trip.algorithm.leet.leet75.mapproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年08月13日 11:22:00
 */
public class Solution1207 {
    public static void main(String[] args) {
        Solution1207 solution1207 =new Solution1207();
        int[] arr = {1,2,2,1,1,3};
        boolean b = solution1207.uniqueOccurrences(arr);
        System.out.println(b);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:arr){
            Integer orDefault = map.getOrDefault(x, 0);
            map.put(x,orDefault+1);
        }
        int size = map.size();
        List<Integer> collect = map.values().stream().distinct().collect(Collectors.toList());
        return size==collect.size();
    }
}
