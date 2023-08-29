package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月26日 09:38:00
 */
public class Solution228 {
    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        int[] nums = {0, 1, 2, 4, 5,6, 7};
        List<String> list = solution228.summaryRanges(nums);
        System.out.println(list);
    }

    public List<String> summaryRanges(int[] nums) {
        int left = -1;
        int length = nums.length;
        List<String> list = new ArrayList<>();
        if(length==0){
            return list;
        }else if(length==1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (left == -1) {
                left = num;
            } else {
                if (num != nums[i - 1] + 1) {
                    int rightVal = nums[i - 1];
                    if (rightVal == left) {
                        list.add(String.valueOf(left));
                    } else {
                        list.add(left + "->" + rightVal);
                    }
                    left = num;
                }
            }
        }
        if(nums[length-2]+1 != nums[length - 1]){
            list.add(String.valueOf(left));
        }else{
            list.add(left + "->" + nums[length - 1]);
        }
        return list;
    }
}
