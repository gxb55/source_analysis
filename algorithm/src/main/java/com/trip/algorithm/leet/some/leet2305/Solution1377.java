package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/5/24 11:16
 */
public class Solution1377 {
    public static void main(String[] args) {
        Solution1377 solution1377 = new Solution1377();
      /*  int n = 7;
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        int t = 2, target = 4;*/
/*
        int n = 7;
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        int t = 1, target = 7;*/
/*
        int n = 8;
        int[][] edges = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}};
        int t = 7, target = 7; */

        int n = 7;
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 20, target = 6;
        double v = solution1377.frogPosition(n, edges, t, target);
        System.out.println(v);
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            int i = arr[0];
            int i1 = arr[1];
            if (map.containsKey(i)) {
                map.get(i).add(i1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i1);
                map.put(i, list);
            }
            if (map.containsKey(i1)) {
                map.get(i1).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(i1, list);
            }
        }
        Map<Integer, Double> valMap = new HashMap<>();
        valMap.put(1, 1.0);
        process(valMap, map, target, t, 1);
        return res;
    }
    double res=0;
    private void process(Map<Integer, Double> valMap, Map<Integer, List<Integer>> map, int target, int t, int cur) {
        if (t == 0) {
            return;
        }

        Double aDouble = valMap.get(cur);
        List<Integer> list = map.get(cur);
        if (list == null) {
            if(cur==target){
                res=valMap.get(cur);
            }
            return;
        }
        List<Integer> collect = list.stream().filter(x -> !valMap.containsKey(x)).collect(Collectors.toList());
        if(collect.size()==0&&cur==target){
            res=valMap.get(cur);
            return;
        }
        double x = (1.0 / collect.size()) * aDouble;
        for (int i = 0; i < collect.size(); i++) {
            Integer val = collect.get(i);
            valMap.put(val, x);
            if((t==1&&val==target)){
                res=x;
            }
            process(valMap, map, target, t - 1, collect.get(i));
        }
    }
}
