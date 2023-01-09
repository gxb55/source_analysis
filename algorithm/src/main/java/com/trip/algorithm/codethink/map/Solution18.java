package com.trip.algorithm.codethink.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/11/9 17:05
 * @description: Solution18
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
       /* int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;*/

       /* int[] nums = {2, 2, 2, 2, 2};
        int target = 8;*/

      /*  int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0; */
/*
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1; */

      /*  int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11; */

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;


        List<List<Integer>> list = solution18.fourSum(nums, target);
        for (List<Integer> temp : list) {
            System.out.println(temp);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        //
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int r = length - 1;
                while (k < r) {
                    Long curVal = Long.valueOf(nums[i]) + Long.valueOf(nums[j]) + Long.valueOf(nums[k]) + Long.valueOf(nums[r]);
                    if (curVal < target) {
                        k++;
                    } else if (curVal > target) {
                        r--;
                    } else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        list1.add(nums[r]);
                        list.add(list1);
                        int curK = nums[k];
                        int curR = nums[r];
                        while (curK == nums[k] && k < r) {
                            k++;
                        }
                        while (curR == nums[r] && k < r) {
                            r--;
                        }
                    }
                }
            }
        }
        return list;
    }
}
