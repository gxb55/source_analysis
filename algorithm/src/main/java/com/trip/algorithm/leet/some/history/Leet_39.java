package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年04月04日 17:44:00
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
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * 通过次数461,119提交次数633,522
 */
public class Leet_39 {
    public static void main(String[] args) {
        Leet_39 leet_39 = new Leet_39();

        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> list = leet_39.combinationSum(candidates, target);
        List<List<Integer>> collect = list.stream().sorted((x, y) -> x.size() - y.size()).collect(Collectors.toList());
        System.out.println("--------------------");
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int index = 0;
        process(candidates, target, index, list, list1);
        return list;
    }

    private void process(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> tempList) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>(tempList);
            list.add(l);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            Integer temp = candidates[i];
            tempList.add(temp);
            process(candidates, target-temp, i, list, tempList);
            tempList.remove(temp);
        }
    }


    private void process1(int[] candidates, int target, List<List<Integer>> list, List<Integer> tempList) {
        if (target == 0) {
            List<Integer> collect = tempList.stream().sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());

            Optional<List<Integer>> first = list.stream().filter(x -> x.size() == tempList.size()).filter(x -> {
                return x.toString().equals(collect.toString());
            }).findFirst();
            if (!first.isPresent()) {
                List<Integer> resultList = new ArrayList<>();
                resultList.addAll(collect);
                list.add(resultList);
            }
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            Integer temp = candidates[i];
            if ((target - temp) >= 0) {
                tempList.add(temp);
                process1(candidates, target - temp, list, tempList);
                tempList.remove(temp);
            }
        }
    }
}
