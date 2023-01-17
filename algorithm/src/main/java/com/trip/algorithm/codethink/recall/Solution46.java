package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/16 14:11
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 通过次数784,279提交次数994,545
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
       // int[] nums = {1, 2, 3};
        int[] nums = {1,0};
        List<List<Integer>> permute = solution46.permute(nums);
        permute.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        process(nums, set, temp, list);
        return list;
    }

    private void process(int[] nums, HashSet<Integer> set, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                temp.add(nums[i]);
                set.add(i);
                process(nums, set, temp, list);
                set.remove(i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
