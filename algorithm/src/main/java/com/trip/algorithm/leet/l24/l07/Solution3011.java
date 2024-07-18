package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;

public class Solution3011 {
    public static void main(String[] args) {
        int[] arr={3,16,8,4,2};
        Solution3011 solution3011 =new Solution3011();
        boolean b = solution3011.canSortArray(arr);
        System.out.println(b);
    }

    public boolean canSortArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int count = -1;
        for (int a : nums) {
            int curCount = getCount(a);
            if (count == -1) {
                count = curCount;
                tempList.add(a);
            } else if (count == curCount) {
                tempList.add(a);
            } else {
                tempList.sort((x, y) -> x - y);
                list.addAll(tempList);
                tempList.clear();

                count = curCount;
                tempList.add(a);
            }
        }
        tempList.sort((x, y) -> x - y);
        list.addAll(tempList);
        int val = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer i1 = list.get(i);
            if (val > i1) {
                return false;
            } else {
                val = i1;
            }
        }
        return true;
    }

    private Integer getCount(int a) {
        String binaryString = Integer.toBinaryString(a);
        int t = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                t++;
            }
        }
        return t;
    }
}
