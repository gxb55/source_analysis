package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/1/16 11:22
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * 通过次数113,554提交次数215,863
 */
public class Solution491 {
    public static void main(String[] args) {
        Solution491 solution491 = new Solution491();
      //  int[] nums = {4, 6, 7, 7,8};
    //    int[] nums = {4,4,3,2,1};
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        List<List<Integer>> subsequences = solution491.findSubsequences(nums);
        subsequences.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        process(nums, 0, -1000, temp, list);
       // List<List<Integer>> collect = list.stream().distinct().collect(Collectors.toList());
        return list;
    }


    private void process(int[] nums, int index, int lastVal, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() >= 2) {
            list.add(new ArrayList<>(temp));
        }
        if (index > nums.length) {
            return;
        }
        boolean[] vis   = new boolean[350];
        for (int i = index; i < nums.length; i++) {
            int curVal = nums[i];
            if (vis[curVal+200]) {
                continue;
            }
            if (lastVal == -1000 || curVal >= lastVal) {
                temp.add(curVal);
                vis[curVal+200] = true;
                process(nums, i + 1, curVal, temp, list);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
