package com.trip.algorithm.leet.some.leet2309;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/9/5 10:55
 */
public class Solution2605 {
    public static void main(String[] args) {

    }
    public int minNumber(int[] nums1, int[] nums2) {

        List<Integer> collect1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> collect = collect1.stream().filter(z -> collect2.contains(z)).collect(Collectors.toList());
        if(collect.size()>0){
          return   collect.stream().min(Integer::compareTo).get();
        }
        Integer integer = collect1.stream().min(Integer::compareTo).get();
        Integer integer1 = collect2.stream().min(Integer::compareTo).get();
        if(integer1<integer){
            return Integer.valueOf(integer1+""+integer);
        }else{
            return Integer.valueOf(integer+""+integer1);
        }
    }
}
