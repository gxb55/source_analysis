package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> orDefault = map.getOrDefault(num, new ArrayList<>());
            orDefault.add(i);
            map.put(num, orDefault);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int v = target - num;
            List<Integer> list = map.get(v);
            if(list!=null){
                int finalI = i;
                List<Integer> collect = list.stream().filter(x -> x != finalI).collect(Collectors.toList());
                if(!collect.isEmpty()){
                    return new int[]{i,collect.get(0)};
                }

            }
        }
        return null;
    }
}
