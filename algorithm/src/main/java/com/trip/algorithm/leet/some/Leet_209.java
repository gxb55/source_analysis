package com.trip.algorithm.leet.some;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Leet_209 {
    public static void main(String[] args) {
        Leet_209 leet_209 = new Leet_209();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = leet_209.minSubArrayLen(target, nums);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (Integer integer : nums) {
            if (target == integer) {
                return 1;
            }
        }
        int len = nums.length;
        Queue<Integer> list = new LinkedList<>();
        int length = len + 1;
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
            while (getSum(list) >= target) {
                length = Math.min(list.size(), length);
                list.poll();
            }
        }
        return length == len + 1 ? 0 : length;
    }

    private int getSum(Queue<Integer> list) {
        int sum=0;
        for(Integer integer:list){
            sum+=integer;
        }
        return sum;
    }
}
