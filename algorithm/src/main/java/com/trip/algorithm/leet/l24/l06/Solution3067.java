package com.trip.algorithm.leet.l24.l06;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;


public class Solution3067 {
    public static void main(String[] args) {
        Solution3067 solution3067 = new Solution3067();
        int[][] edges = {{0, 6, 3}, {6, 5, 3}, {0, 3, 1}, {3, 2, 7}, {3, 1, 6}, {3, 4, 2}};
        int signalSpeed = 3;
        int[] ints = solution3067.countPairsOfConnectableServers(edges, signalSpeed);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            int x = arr[0];
            int y = arr[1];
            int v = arr[2];
            Map<Integer, Integer> orDefault = map.getOrDefault(x, new HashMap<>());
            orDefault.put(y, v);
            map.put(x, orDefault);

            Map<Integer, Integer> orDefault1 = map.getOrDefault(y, new HashMap<>());
            orDefault1.put(x, v);
            map.put(y, orDefault1);
        }

        int len = edges.length;
        int[] res = new int[len+1];
        for (int i = 0; i < len+1; i++) {
            int sum = 0;
            Map<Integer, Integer> map1 = map.get(i);
            if (null != map1) {
                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                    int cnt = process(i, entry.getKey(), entry.getValue(), signalSpeed, map);
                    res[i] += cnt * sum;
                    sum = sum + cnt;
                }
            }
        }
        return res;
    }

    private int process(int l, Integer r, Integer v, int signalSpeed, Map<Integer, Map<Integer, Integer>> map) {
        int count = v % signalSpeed == 0 ? 1 : 0;
        Map<Integer, Integer> map1 = map.get(r);
        if (null != map1) {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                if (entry.getKey() != l) {
                    count += process(r, entry.getKey(), entry.getValue()+v, signalSpeed, map);
                }
            }
        }
        return count;
    }

}
