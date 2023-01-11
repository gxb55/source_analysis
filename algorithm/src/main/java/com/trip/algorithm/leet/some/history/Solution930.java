package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/3/24  21:25
 * @description 930
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * 通过次数36,816提交次数67,403
 */
public class Solution930 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1};
        int goal = 2;
        Solution930 solution930 = new Solution930();
        int i = solution930.numSubarraysWithSum(arr, goal);
        System.out.println(i);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int a = sum - goal;
            res = res + map.getOrDefault(a, 0);
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return res;
    }

    public int numSubarraysWithSum1(int[] nums, int S) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-S)){
                res += map.get(sum-S);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

}
