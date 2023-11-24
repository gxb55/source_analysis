package com.trip.algorithm.leet.some.leet2311;

import java.util.List;

/**
 * @author xbguo
 * @date 2023/11/24 15:30
 */
public class Solution2824 {
    public static void main(String[] args) {

    }
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if((nums.get(i)+nums.get(j))<target){
                    count++;
                }
            }
        }
        return count;
    }
}
