package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/11 15:56
 * @description Solution78
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 * 通过次数563,865提交次数696,365
 */
public class Solution78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        subsets.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(nums, 0, tempList, list);
        list.add(new ArrayList<>());
        return list;
    }

    private void process(int[] nums, int index, List<Integer> tempList, List<List<Integer>> list) {
        if (!tempList.isEmpty()) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            process(nums, i + 1, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
