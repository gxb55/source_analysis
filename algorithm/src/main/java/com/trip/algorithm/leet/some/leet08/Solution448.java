package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/10  19:50
 * @description Solution448
 */
public class Solution448 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        //int[] arr = {1, 1};
        Solution448 solution448 = new Solution448();
        List<Integer> disappearedNumbers = solution448.findDisappearedNumbers1(arr);
        System.out.println(disappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i <= n) {
                arr[i - 1] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(nums[Math.abs(num) - 1]>0){
                nums[Math.abs(num) - 1] = -nums[Math.abs(num) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
