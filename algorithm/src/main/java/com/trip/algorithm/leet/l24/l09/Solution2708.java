package com.trip.algorithm.leet.l24.l09;

import java.util.ArrayList;
import java.util.List;

public class Solution2708 {
    public static void main(String[] args) {
       // int[] arr={3,-1,-5,2,5,-9};
        int[] arr={0,-1};
        long l = maxStrength(arr);
        System.out.println(l);
    }

    public static long maxStrength(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int count=0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int t : nums) {
            if (t < 0) {
                list2.add(t);
            } else if (t > 0) {
                list1.add(t);
            }else {
                count++;
            }
        }
        // 从小到大
        list2.sort((x, y) -> y - x);
        while (!list2.isEmpty() && list2.size() % 2 != 0) {
            list2.remove(0);
        }
        if(list2.isEmpty()&&list1.isEmpty()&&count>0){
            return 0;
        }
        long res = 1;
        for (Integer i1 : list1) {
            res = res * i1;
        }
        for (Integer i1 : list2) {
            res = res * i1;
        }
        return res;
    }
}
