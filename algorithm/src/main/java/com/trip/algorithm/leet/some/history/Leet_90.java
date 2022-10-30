package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年04月16日 21:03:00
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 通过次数190,162提交次数299,919
 */
public class Leet_90 {
    public static void main(String[] args) {
        Leet_90 lee_90 = new Leet_90();
        int[] nums = {4,4,4,1,4};
        Arrays.sort(nums);
        List<List<Integer>> list = lee_90.subsetsWithDup(nums);
        list.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int begin = 0;
        process(nums, begin, tempList, result);
        List<List<Integer>> collect = result.stream().distinct().collect(Collectors.toList());
        return collect;
    }

    private void process(int[] nums, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        process(nums, index + 1, tempList, result);
        tempList.add(nums[index]);
        process(nums, index + 1, tempList, result);
        tempList.remove(Integer.valueOf(nums[index]));
    }
}
