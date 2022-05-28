package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月05日 08:51:00
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
 * 通过次数269,042提交次数441,490
 */
public class Leet_40 {
    public static void main(String[] args) {
        Leet_40 leet_40 = new Leet_40();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = leet_40.combinationSum2(candidates, target);
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        int sum = 0;
        for (int i : candidates) {
            sum += i;
        }
        if (sum < target) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        int index = 0;
        process(candidates, target, index, tempList, result);
        return result;
    }

    /**
     * @param candidates 数组 不变的
     * @param target     目标值
     * @param index      下标
     * @param tempList   临时答案
     * @param result     最终答案
     */
    private void process(int[] candidates, int target, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ((target - candidates[i]) < 0) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            process(candidates, target - candidates[i], i + 1, tempList, result);
            tempList.remove(Integer.valueOf(candidates[i]));
        }
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        int sum = 0;
        for (int i : candidates) {
            sum += i;
        }
        if (sum < target) {
            return null;
        }
        int x = candidates.length + 1;
        int y = target + 1;
        int[][] dp = new int[x][y];

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if ((j - candidates[i]) >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - candidates[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(dp[i][j] + "     ");
            }
            System.out.println();
        }


        return new ArrayList<>();
    }
}
