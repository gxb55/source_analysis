package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/14 19:45
 */
public class Solution841 {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        int cur=0;
        List<Integer> curList =rooms.get(0);
        while (!list.isEmpty()){

        }
        return false;
    }
}
