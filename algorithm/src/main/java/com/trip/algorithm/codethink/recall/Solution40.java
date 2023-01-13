package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author xbguo
 * @date 2023/1/11 14:33
 * @description Solution40
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 通过次数382,273提交次数634,460
 */
public class Solution40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> list = solution40.combinationSum2(candidates, target);
        list.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();

        process(candidates, 0, target, 0, tempList, list);
        return list;
    }

    private void process(int[] candidates, int index, int target, int curSum, List<Integer> tempList, List<List<Integer>> list) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        Boolean[] vis = new Boolean[candidates.length];
        for (int i = index; i < candidates.length; i++) {
            vis[i] = true;
            int candidate = candidates[i];
            if (i > 0 && candidate == candidates[i - 1] && Objects.equals(vis[i - 1], true)) {
                continue;
            }
            tempList.add(candidate);
            process(candidates, i + 1, target, curSum + candidate, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
