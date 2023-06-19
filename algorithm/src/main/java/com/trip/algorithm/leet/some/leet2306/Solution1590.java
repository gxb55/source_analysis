package com.trip.algorithm.leet.some.leet2306;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/16 16:46
 */
public class Solution1590 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        int p = 6;

       /* int[] nums = {6,3,5,2};
        int p = 9;*/
/*
        int[] nums = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        int p = 148;*/
        int i = minSubarray(nums, p);
        System.out.println(i);
    }
    public static int minSubarray1(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % p == 0) {
            return 0;
        }
        if (sum < p) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        long k = sum % p;
        while (k < sum) {
            for (int i = 0; i < nums.length; i++) {
                int cur=0;
                for (int j = i; j < nums.length; j++) {
                    cur+=nums[j];
                    if(cur==k){
                        System.out.println(i+"_"+j);
                    }
                }

            }
            k = k + p;
        }
        return -1;
    }
    public static int minSubarray(int[] nums, int p) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,0);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i+1);
        }
        if (sum % p == 0) {
            return 0;
        }
        if (sum < p) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        long k = sum % p;
        Map<Long,Integer> map1 = new HashMap<>();
        map1.putAll(map1);
        while (k < sum) {
            long finalK = k;
            boolean b = map.entrySet().stream().map(x -> x.getKey()).map(x -> x - finalK).anyMatch(x -> map.containsKey(x));
            if (b) {
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    Long key = entry.getKey();
                    Integer integer = map.get(key - k);
                    if(integer!=null){
                        max = Math.min(max, entry.getValue() - integer);
                    }
                }
                return max;
            } else {
                k = k + p;
            }
        }
        return -1;
    }
}
