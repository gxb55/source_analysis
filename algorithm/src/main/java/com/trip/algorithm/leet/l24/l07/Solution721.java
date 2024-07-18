package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/7/15 21:05
 * @description TODO
 */
public class Solution721 {

    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            int finalI = i;
            list.stream().forEach(x -> {
                List<Integer> orDefault = map.getOrDefault(x, new ArrayList<>());
                orDefault.add(finalI);
                map.put(x, orDefault);
            });
        }
        Set<Integer> set =new HashSet<>();
        for (int i = 0; i < accounts.size(); i++) {
            if(set.contains(i)){
                continue;
            }
            List<Integer> list =new ArrayList<>();
            
          
        }
        return null;
    }
}
