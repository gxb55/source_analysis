package com.trip.algorithm.leet.some.leet2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年10月23日 17:48:00
 */
public class Solution2441 {
    public static void main(String[] args) {
        Solution2441 solution2441 = new Solution2441();
     //   int[] arr={-1,2,-3,3};
        //int[] arr={-1,10,6,7,-7,1};
        int[] arr={-10,8,6,7,-2,-3};
        int maxK = solution2441.findMaxK(arr);
        System.out.println(maxK);
    }
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(x->list.add(x));
        int len=nums.length;
        for (int i = len-1; i >=0; i--) {
            int cur=nums[i];
            if(cur>0){
                boolean contains = list.contains(Integer.valueOf("-" + cur));
                if(contains){
                    return cur;
                }
            }
        }
        return -1;
    }
}
