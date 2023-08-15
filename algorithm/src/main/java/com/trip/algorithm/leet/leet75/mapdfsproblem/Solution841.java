package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/14 19:45
 */
public class Solution841 {
    public static void main(String[] args) {
        Solution841 solution841 =new Solution841();
        Integer[][] rooms = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] arr:rooms){
            list.add(List.of(arr));
        }
        boolean b = solution841.canVisitAllRooms(list);
        System.out.println(b);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        List<Integer> keyList = new ArrayList<>();
        keyList.add(0);
        boolean[] vis = new boolean[rooms.size()];
        Arrays.fill(vis, false);
        process(keyList, rooms, vis);
        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void process(List<Integer> keyList, List<List<Integer>> rooms, boolean[] vis) {
        if (keyList.isEmpty()) {
            return;
        }
        while (!keyList.isEmpty()) {
            Integer remove = keyList.remove(0);
            if (!vis[remove]) {
                keyList.addAll(rooms.get(remove));
                vis[remove] = true;
                break;
            }
        }
        process(keyList, rooms, vis);
    }
}
