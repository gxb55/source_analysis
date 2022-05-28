package com.trip.algorithm.leet.some;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年05月15日 21:50:00
 */
public class Leet_2251 {
    public static void main(String[] args) {
        Leet_2251 l = new Leet_2251();
       /* int[][] flowers = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] persons = {2, 3, 7, 11};*/
       /* int[][] flowers = {{1, 10}, {3, 3}};
        int[] persons = {3, 3, 2};*/


        int[][] flowers = {{19, 37}, {19, 38}, {19, 35}};
        int[] persons = {6, 7, 21, 1, 13, 37, 5, 37, 46, 43};
        int[] ints = l.fullBloomFlowers1(flowers, persons);
        System.out.println(Arrays.toString(ints));
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = persons[0];
        int min = persons[0];
        for (int x : persons) {
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        for (int[] arr : flowers) {
            int begin = arr[0];
            int end = arr[1];
            if (end < min || begin > max) {
                continue;
            }
            for (int i = begin; i <= end; i++) {
                Integer integer = map.get(i);
                if (integer == null) {
                    map.put(i, 1);
                } else {
                    map.put(i, integer + 1);
                }
            }
        }
        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            res[i] = map.getOrDefault(persons[i], 0);
        }
        return res;
    }

    public int[] fullBloomFlowers1(int[][] flowers, int[] persons) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            int x = 0;
            int person = persons[i];
            if (map.containsKey(person)) {
                res[i] = map.get(person);
                continue;
            }
            for (int[] arr : flowers) {
                int begin = arr[0];
                int end = arr[1];
                if (person >= begin && person <= end) {
                    x++;
                }
            }
            map.put(person, x);
            res[i] = x;
        }
        return res;
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] persons) {
        List<Integer> start = new ArrayList<>(),end = new ArrayList<>();
        for(int[] flower : flowers){
            start.add(flower[0]);
            end.add(flower[1]);
        }
        start.sort((o1, o2) -> o1 - o2);
        end.sort((o1, o2) -> o1 - o2);
        int[] res = new int[persons.length];
        for(int i = 0; i < persons.length; ++i){
            //  二分计算有多少花在 <= persion[i]时刻开放
            int l = 0,r = start.size() - 1;
            int cnt = 0;
            while (l < r){
                int mid = (r - l + 1) / 2 + l;
                if(start.get(mid) > persons[i]) r = mid - 1;
                else l = mid;
            }
            if(start.get(l) <= persons[i]){
                cnt += (l + 1);
            }

            // 二分计算有多少花在 < person[i] 到达时候凋谢
            l = 0;r = end.size() - 1;
            while (l < r){
                int mid = (r - l + 1) / 2 + l;
                if(end.get(mid) >= persons[i]) r = mid - 1;
                else l = mid;
            }
            if(end.get(l) < persons[i]){
                cnt -= (l + 1);
            }

            res[i] = cnt;
        }
        return res;
    }
}
