package com.trip.algorithm.leet.l24.l01;

import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/1/25 20:31
 */
public class Solution2859 {
    public static void main(String[] args) {
        Solution2859 solution2859 =new Solution2859();
        List<Integer> nums = Arrays.asList(5,10,1,5,2); int k = 1;
        int i = solution2859.sumIndicesWithKSetBits(nums, k);
        System.out.println(i);
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res=0;
        for (int i = 0; i < nums.size(); i++) {
            String binaryString = Integer.toBinaryString(i);
            char[] charArray = binaryString.toCharArray();
            int count = 0;
            for (char c : charArray) {
                if (c == '1') {
                    count++;
                }
            }
            if(count == k){
                res+=nums.get(i);
            }
        }
        return res;
    }
}
