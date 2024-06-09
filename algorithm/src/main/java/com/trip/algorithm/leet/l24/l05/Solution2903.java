package com.trip.algorithm.leet.l24.l05;

import com.alibaba.fastjson.JSON;

public class Solution2903 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 1};
        int indexDifference = 2, valueDifference = 4;
        int[] indices = findIndices(arr, indexDifference, valueDifference);
        System.out.println(JSON.toJSONString(indices));
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(Math.abs(i-j)>=indexDifference){
                    if (Math.abs(nums[j] - nums[i]) >= valueDifference) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}
