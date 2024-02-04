package com.trip.algorithm.leet.l24.l01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution365 {
    public static void main(String[] args) {
        Solution365 solution365 = new Solution365();
       // int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
        int jug1Capacity = 22003, jug2Capacity = 31237, targetCapacity = 1;
        boolean b = solution365.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        System.out.println(b);
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if ((jug1Capacity + jug2Capacity) == targetCapacity) {
            return true;
        }
        int lastLen = 0;
        List<Integer> list = new ArrayList<>();
        list.add(jug1Capacity);
        list.add(jug2Capacity);
        while (list.size() > lastLen) {
            lastLen = list.size();
            list.sort((o1, o2) -> o1.compareTo(o2));
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    list1.add(list.get(j) - list.get(i));
                }
            }
            list.addAll(list1);
            list = list.stream().distinct().collect(Collectors.toList());

        }
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            int x = targetCapacity - val;
            if (list.contains(Math.abs(x))) {
                return true;
            }
        }
        return false;
    }
}
