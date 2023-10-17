package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年10月15日 10:12:00
 */
public class Solution137 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        Arrays.stream(nums).forEach(x->{
            int i = map.getOrDefault(x, 0) + 1;
            map.put(x,i);
        });
        Integer key = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
        return key;

    }
}
