package com.trip.algorithm.leet.some.leet2309;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年09月10日 08:06:00
 */
public class Solution207 {
    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
       /* int numCourses = 2;
        int[][] prerequisites = {{1, 0}}; */
       /* int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};*/

     /*   int numCourses = 7;
        int[][] prerequisites = {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};*/
        // int[][] prerequisites = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};

        int numCourses = 3;
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        boolean b = solution207.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dp = new int[numCourses];
        for (int[] arr : prerequisites) {
            dp[arr[0]]++;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(prerequisites).forEach(x -> {
            List<Integer> orDefault = map.getOrDefault(x[1], new ArrayList<>());
            orDefault.add(x[0]);
            map.put(x[1], orDefault);
        });
        LinkedList<Integer> collect = new LinkedList<>();
        boolean[] vis = new boolean[numCourses];
        Arrays.fill(vis, false);
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                collect.add(i);
                vis[i] = true;
            }
        }

        while (!collect.isEmpty()) {
            Integer remove = collect.pollLast();
            List<Integer> list = map.get(remove);
            if (list != null) {
                for (int x:list){
                    dp[x]--;
                    if(!vis[x]&&dp[x]==0){
                        vis[x]=true;
                        collect.addFirst(x);
                    }
                }
            }
        }
        boolean b = Arrays.stream(dp).boxed().allMatch(x -> x == 0);
        return b;
    }
}
