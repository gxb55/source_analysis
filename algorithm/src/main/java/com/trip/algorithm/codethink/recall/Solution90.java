package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/1/13 14:18
 * @description Solution90
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
 * 通过次数265,764提交次数417,385
 */
public class Solution90 {
    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        //int[] nums = {1, 2, 2,3};
        int[] nums = {5, 5, 5, 5};
        List<List<Integer>> list = solution90.subsetsWithDup(nums);
        list.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.vis = new Boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(nums, 0, tempList, list);
        list.add(new ArrayList<>());
        List<List<Integer>> collect = list.stream().distinct().collect(Collectors.toList());
        return collect;
    }

    Boolean vis[];

    private void process(int[] nums, int index, List<Integer> tempList, List<List<Integer>> list) {
        if (index > nums.length) {
            return;
        }
        if (!tempList.isEmpty()) {
            list.add(new ArrayList<>(tempList));
        }

        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && Objects.equals(vis[i - 1], false)) {
                continue;
            }
            vis[i] = true;
            int val = nums[i];
            tempList.add(val);
            process(nums, i + 1, tempList, list);
            tempList.remove(tempList.size() - 1);
            vis[i] = false;
        }
    }
}
