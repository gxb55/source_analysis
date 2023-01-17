package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/16 14:20
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 通过次数411,510提交次数629,385
 */
public class Solution47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
       // int[] nums = {1, 1, 2};
        int[] nums = {1, 3, 2};
        List<List<Integer>> list = solution47.permuteUnique(nums);
        list.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        process(nums, set, temp, list, vis);
        return list;
    }

    private void process(int[] nums, HashSet<Integer> set, List<Integer> temp, List<List<Integer>> list, boolean[] vis) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }
            set.add(i);
            temp.add(nums[i]);
            vis[i] = true;
            process(nums, set, temp, list, vis);
            vis[i] = false;
            temp.remove(temp.size() - 1);
            set.remove(i);
        }
    }
}
