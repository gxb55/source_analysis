package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/11 14:19
 * @description 39
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = {2, 3, 5};
        int target = 7;
        List<List<Integer>> list = solution39.combinationSum(candidates, target);
        list.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        process(candidates, 0, target, 0, tempList, list);
        return list;
    }

    private void process(int[] candidates, int index, int sum, int curSum, List<Integer> tempList, List<List<Integer>> list) {
        if (curSum > sum) {
            return;
        }
        if (sum == curSum) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            tempList.add(candidate);
            process(candidates, i, sum, curSum + candidate, tempList, list);
            tempList.remove(tempList.size() - 1);
        }

    }
}
