package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/10/16 10:01
 */
public class Solution260 {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,2,5};
        int[] ints = singleNumber(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] singleNumber(int[] nums) {
        if(nums.length==2){
            return nums;
        }
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        String s = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        char[] chars = s.toCharArray();
        int index = -1;
        for (int i = 0; i <chars.length; i++) {
            if (chars[i] == '1') {
                index = i;
                break;
            }
        }
        Integer x1 = null;
        Integer x2 = null;
        for (Integer c : nums) {
            String s1 = String.format("%32s", Integer.toBinaryString(c)).replace(' ', '0');
            Character i = s1.charAt(index);
            if (i == '0') {
                if (x1 == null) {
                    x1 = c;
                } else {
                    x1 = x1 ^ c;
                }
            } else {
                if (x2 == null) {
                    x2 = c;
                } else {
                    x2 = x2 ^ c;
                }
            }
        }
        return new int[]{x1, x2};
    }
}
