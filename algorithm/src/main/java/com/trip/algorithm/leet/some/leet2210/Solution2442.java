package com.trip.algorithm.leet.some.leet2210;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年10月23日 17:54:00
 */
public class Solution2442 {
    public static void main(String[] args) {
        Solution2442 solution2442 = new Solution2442();
       // int[] arr = {1, 13, 10, 12, 31};
        int[] arr = {2,2,2};
        int i = solution2442.countDistinctIntegers(arr);
        System.out.println(i);
    }

    public int countDistinctIntegers(int[] nums) {
        Set<String> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            String s = String.valueOf(num);
            set.add(s);
            String reverse = new StringBuffer(s).reverse().toString();
            while (reverse.charAt(0) == '0') {
                reverse = reverse.substring(1);
            }
            set.add(reverse);
        }
        return set.size();
    }
}
