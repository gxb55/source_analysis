package com.trip.algorithm.leet.some.everday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年07月24日 21:43:00
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
 * 通过次数487,580提交次数604,287
 */
public class Solution78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = solution78.subsets1(arr);
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }
        /*List<List<Integer>> subsets = solution78.subsets(arr);
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }*/

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(0, nums, tempList, res);
        return res;
    }

    private void process(int index, int[] nums, List<Integer> tempList, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(tempList);
            res.add(list);
            return;
        }
        tempList.add(nums[index]);
        process(index + 1, nums, tempList, res);
        tempList.remove(Integer.valueOf(nums[index]));
        process(index + 1, nums, tempList, res);

    }

    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int start = (int) Math.pow(2, n);
        double end = Math.pow(2, n + 1);
        for (int i = start; i < end; i++) {
            tempList.clear();
            String substring = Integer.toBinaryString(i).substring(1);
            // System.out.println(substring);
            for (int j = 0; j < n; j++) {
                if (substring.charAt(j) == '1') {
                    tempList.add(nums[j]);
                }
            }
            res.add(new ArrayList(tempList));
        }
        return res;
    }
}
