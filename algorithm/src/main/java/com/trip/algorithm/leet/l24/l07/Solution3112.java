package com.trip.algorithm.leet.l24.l07;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/7/18 10:29
 */
public class Solution3112 {

    public static void main(String[] args) {
     /*   int n = 3;
        int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
        int[] disappear = {1, 1, 5};
        */
      /*  int n = 2;
        int[][] edges = {{0, 1, 1}};
        int[] disappear = {1, 1};  */

        int n = 3;
        int[][] edges = {{2, 0, 9}, {1, 0, 5}, {2, 2, 4}, {0, 1, 10}, {1, 1, 10}, {1, 1, 10}, {2, 2, 10}, {1, 1, 10}};
        int[] disappear = {4, 13, 19};
        Solution3112 solution3112 = new Solution3112();
        int[] ints = solution3112.minimumTime(n, edges, disappear);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int[] arr : edges) {
            int x = arr[0];
            int y = arr[1];
            int z = arr[2];
            List<Integer> orDefault = graphMap.getOrDefault(x, new ArrayList<>());
            orDefault.add(y);
            graphMap.put(x, orDefault);

            List<Integer> orDefault1 = graphMap.getOrDefault(y, new ArrayList<>());
            orDefault1.add(x);
            graphMap.put(y, orDefault1);
            String v = x + "_" + y;
            Integer integer = map.get(v);
            if (integer == null || integer > z) {
                map.put(v, z);
            }
            v = y + "_" + x;
            integer = map.get(v);
            if (integer == null || integer > z) {
                map.put(v, z);
            }
       
        }
        int[] res = new int[n];
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            List<Integer> list = new ArrayList<>();
            process(0, i, graphMap, 0, list, 0, map, disappear);
            res[i] = list.isEmpty() ? -1 : list.get(0);
        }
        for (int i = 1; i < disappear.length; i++) {
            if (res[i] == -1) {
                continue;
            }
            if (disappear[i] < res[i]) {
                res[i] = -1;
            }
        }
        return res;
    }

    private void process(int cur, int end, Map<Integer, List<Integer>> map, int lastVal, List<Integer> list, int i, Map<String, Integer> stringIntegerMap, int[] disappear) {
        if (cur == end) {
            if (list.isEmpty()) {
                list.add(i);
            } else {
                Integer integer = list.get(0);
                if (integer > i) {
                    list.remove(0);
                    list.add(i);
                }
            }
            return;
        }
        List<Integer> list1 = map.get(cur);
        if (list1 != null) {
            for (int z : list1) {
                if (z == lastVal) {
                    continue;
                }
                int v = i + stringIntegerMap.get(cur + "_" + z);
                if (v >= disappear[z]) {
                    continue;
                }
                process(z, end, map, cur, list, v, stringIntegerMap, disappear);
            }
        }

    }
}
