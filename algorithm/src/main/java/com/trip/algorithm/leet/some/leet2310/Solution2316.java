package com.trip.algorithm.leet.some.leet2310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/10/23 19:29
 */
public class Solution2316 {
    public static void main(String[] args) {
      /*  int n = 3;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};*/

       /* int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}}; */

        int n = 7;
        int[][] edges = {{5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}};
        long l = countPairs(n, edges);
        System.out.println(l);
    }

    public static long countPairs(int n, int[][] edges) {
        List<Integer> total =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            total.add(i);
        }
        List<Set<Integer>> list = new ArrayList<>();
        for (int[] arr : edges) {
            int i = arr[0];
            int j = arr[1];
            total.remove(Integer.valueOf(i));
            total.remove(Integer.valueOf(j));
            Set<Integer> set1 = list.stream().filter(x -> x.contains(i)).findFirst().orElse(null);
            Set<Integer> set2 = list.stream().filter(x -> x.contains(j)).findFirst().orElse(null);
            if (set2 == null && set1 == null) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                set.add(j);
                list.add(set);
            } else if (set2 == null && set1 != null) {
                set1.add(j);
            } else if (set2 != null && set1 == null) {
                set2.add(i);
            } else {
                list.remove(set2);
                list.remove(set1);
                set1.addAll(set2);
                list.add(set1);
            }
        }
        total.stream().forEach(x->{
            Set<Integer> set = new HashSet<>();
            set.add(x);
            list.add(set);
        });
        if(list.size()==1){
            return 0;
        }
        int count = 0;
        int curTotal = n;
        for (Set<Integer> set : list) {
            int size = set.size();
            count=count+( size * (curTotal - size));
            curTotal = curTotal - size;
        }
        return count;
    }
}
