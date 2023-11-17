package com.trip.algorithm.leet.some.leet2311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/11/14 10:19
 */
public class Solution1334 {
    public static void main(String[] args) {
        Solution1334 solution1334 = new Solution1334();
        /*int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;*/

      /*  int n = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2; */

    /*    int n = 6;
        int[][] edges = {{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}};
        int distanceThreshold = 417;
*/
    int n = 6;
        int[][] edges = {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}};
        int distanceThreshold = 20;

        int theCity = solution1334.findTheCity1(n, edges, distanceThreshold);
        System.out.println(theCity);
    }
        public int findTheCity1(int n, int[][] edges, int distanceThreshold) {
            int[] ans = {Integer.MAX_VALUE / 2, -1};
            int[][] mp = new int[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(mp[i], Integer.MAX_VALUE / 2);
            }
            for (int[] eg : edges) {
                int from = eg[0], to = eg[1], weight = eg[2];
                mp[from][to] = mp[to][from] = weight;
            }
            for (int k = 0; k < n; ++k) {
                mp[k][k] = 0;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        mp[i][j] = Math.min(mp[i][j], mp[i][k] + mp[k][j]);
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                int cnt = 0;
                for (int j = 0; j < n; ++j) {
                    if (mp[i][j] <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= ans[0]) {
                    ans[0] = cnt;
                    ans[1] = i;
                }
            }
            return ans[1];
        }



    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Line>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] arr : edges) {
            int x = arr[0];
            int y = arr[1];
            int j = arr[2];
            List<Line> orDefault = map.getOrDefault(x, new ArrayList<>());
            orDefault.add(new Line(x, y, j));
            map.put(x, orDefault);

            List<Line> orDefault1 = map.getOrDefault(y, new ArrayList<>());
            orDefault1.add(new Line(y, x, j));
            map.put(y, orDefault1);
            set.add(x);
            set.add(y);
        }
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        for (Integer k : set) {
            Set<Integer> set1 = new HashSet<>();
            process(map, set1, distanceThreshold, k);
            set1.remove(k);
            map1.put(k, set1);
        }

        List<Map.Entry<Integer, Set<Integer>>> collect = map1.entrySet().stream().sorted((x, y) -> x.getValue().size() - y.getValue().size()).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        int size = collect.get(0).getValue().size();
        for (Map.Entry<Integer, Set<Integer>> entry : collect) {
            if (entry.getValue().size() == size) {
                list.add(entry.getKey());
            }else {
                break;
            }
        }
        List<Integer> collect1 = list.stream().sorted((x, y) -> {
            return y - x;

        }).collect(Collectors.toList());

        return collect1.get(0);

    }

    private void process(Map<Integer, List<Line>> map, Set<Integer> set, int distanceThreshold, Integer k) {
        if (distanceThreshold < 0) {
            return;
        }
        if (!set.add(k)) {
            return;
        }
        List<Line> lines = map.get(k);
        if (lines == null) {
            return;
        }
        for (Line line : lines) {
            if (line.weight > distanceThreshold) {
                continue;
            }
            if (set.contains(line.end)) {
                continue;
            }
            process(map, set, distanceThreshold - line.weight, line.end);
        }
    }

    class Line {
        public int begin;
        public int end;
        public int weight;

        public Line(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "begin=" + begin +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
}
