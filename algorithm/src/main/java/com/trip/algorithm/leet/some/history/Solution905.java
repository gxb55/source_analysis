package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/28  10:53
 * @description 905
 */
public class Solution905 {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int a:nums){
            if(a%2==0){
                list.add(a);
            }else{
                list1.add(a);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        int x = list.size();
        for (int i = 0; i < list1.size(); i++) {
            nums[x+i]=list1.get(i);
        }
        return nums;

    }
}
