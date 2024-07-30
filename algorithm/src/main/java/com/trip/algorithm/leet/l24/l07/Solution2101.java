package com.trip.algorithm.leet.l24.l07;

import java.util.*;

/**
 * @author xbguo
 * @date 2024/7/22 14:24
 */
public class Solution2101 {

    public static void main(String[] args) {
        //  int[][] bombs = {{1,1,5},{10,10,5}};
        int[][] bombs = {{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}};
        int i = maximumDetonation(bombs);
        System.out.println(i);
    }

    public static int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected(bombs, i, j)) {
                    orDefault.add(j);
                }
            }
            map.put(i, orDefault);
        }
        int count = 0;
        Set<Integer> set = new HashSet<>(bombs.length);
        for (int i = 0; i < bombs.length; i++) {
            set.clear();
            List<Integer> list = map.get(i);
            set.add(i);
            LinkedList<Integer> temp = new LinkedList<>(list);
            while (!temp.isEmpty()) {
                Integer i1 = temp.pollFirst();
                if (!set.add(i1)) {
                    continue;
                }
                List<Integer> list1 = map.get(i1);
                if(list1==null){
                    continue;
                }
                temp.addAll(new ArrayList<>(list1));
            }
            count = Math.max(count, set.size());
        }
        return count;
    }

    public static boolean isConnected(int[][] bombs, int u, int v) {
        long dx = bombs[u][0] - bombs[v][0];
        long dy = bombs[u][1] - bombs[v][1];
        return (long) bombs[u][2] * bombs[u][2] >= dx * dx + dy * dy;
    }


}
