package com.trip.algorithm.leet.leet75.arraystringproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xbguo
 * @date 2023/8/16 19:19
 */
public class Solution334 {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5};
      //  int[] nums = {5,4,3,2,1};
      //  int[] nums = {2,1,5,0,4,6};
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,7};
        boolean b = increasingTriplet(nums);
        System.out.println(b);

    }

    public static boolean increasingTriplet(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                continue;
            }else{
                list.add(nums[i]);
            }
        }
        nums=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Optional<Integer> first = list.stream().limit(i).filter(x -> x < num).findFirst();
            if (first.isPresent()) {
                Optional<Integer> first1 = list.stream().skip(i + 1).filter(x -> x > num).findFirst();
                if (first1.isPresent()) {
                    return true;
                }
            }
        }
        return false;
    }
}
