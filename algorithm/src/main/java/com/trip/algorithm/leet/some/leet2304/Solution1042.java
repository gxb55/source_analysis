package com.trip.algorithm.leet.some.leet2304;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年04月15日 10:04:00
 */
public class Solution1042 {
    public static void main(String[] args) {
        Solution1042 solution1042 = new Solution1042();

        /*int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};*/

      /*  int n = 4;
        int[][] paths = {{1,2},{3,4}};*/

        int n = 4;
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};

      /*  int n = 5;
        int[][] paths = {{4, 1}};
*/
        int[] ints = solution1042.gardenNoAdj1(n, paths);
        System.out.println(Arrays.toString(ints));
    }

    public int[] gardenNoAdj1(int n, int[][] paths) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] path : paths) {
            adj[path[0] - 1].add(path[1] - 1);
            adj[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] colored = new boolean[5];
            for (int vertex : adj[i]) {
                colored[ans[vertex]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!colored[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }



    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int k = 0; k < paths.length; k++) {
            int[] a = paths[k];
            int i = a[0];
            int j = a[1];
            Set<Integer> set = map.get(i);
            Set<Integer> set1 = map.get(j);
            if (set1 != null && set != null) {
                map.remove(Integer.valueOf(i));
                set1.add(k);
                set1.addAll(set);
                map.put(Integer.valueOf(j), set1);
            } else if (set1 != null && set == null) {
                set1.add(k);
                map.put(i, set1);
                map.put(j, set1);
            } else if (set1 == null && set != null) {
                set.add(k);
                map.put(i, set);
                map.put(j, set);
            } else {
                set = new HashSet<>();
                set.add(k);
                map.put(i, set);
                map.put(j, set);

            }
        }
        for (int k = 0; k < paths.length; k++) {
            int[] a = paths[k];
            int i = a[0];
            int j = a[1];
            Set<Integer> set = map.get(i);
            Set<Integer> set1 = map.get(j);
            if (set1 != null && set != null) {
                map.remove(j);
                set1.addAll(set);
                map.put(i, set1);
            }

        }
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = map.get(i);
            if (set != null) {
                Set<Integer> set1 = new HashSet<>();
                for (int x : set) {
                    set1.add(paths[x][0]);
                    set1.add(paths[x][1]);
                }
                List<Integer> collect = set1.stream().sorted((x, y) -> x - y).collect(Collectors.toList());
                int index = 1;
                for (int x : collect) {
                    if (arr[x - 1] == 0) {
                        arr[x - 1] = index;
                        index++;
                    }
                }
            }
        }
        return arr;
    }
}
