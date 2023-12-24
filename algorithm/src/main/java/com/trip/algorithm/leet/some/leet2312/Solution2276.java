package com.trip.algorithm.leet.some.leet2312;

import java.util.TreeMap;

public class Solution2276 {
    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        //["CountIntervals", "add", "add", "count", "add", "count"]
        //[[], [2, 3], [7, 10], [], [5, 8], []]
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        System.out.println(countIntervals.count());
        countIntervals.add(5, 8);
        System.out.println(countIntervals.count());
    }
}

class CountIntervals {

    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private int count = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        Integer l = treeMap.floorKey(right);
        while (l != null && treeMap.get(l) >= left) {
            Integer r = treeMap.get(l);
            left = Math.min(left, l);
            right = Math.max(right, r);
            int v = r - l + 1;
            count = count - v;
            treeMap.remove(l);
            l = treeMap.floorKey(right);

        }
        treeMap.put(left, right);
        count += right - left + 1;
    }

    public int count() {
        return count;
    }
}