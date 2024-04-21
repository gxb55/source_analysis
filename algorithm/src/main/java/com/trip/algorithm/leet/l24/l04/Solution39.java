package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = solution39.combinationSum(candidates, target);
        list.stream().forEach(x -> System.out.println(x));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(0, tempList, list, target, candidates);
        return list;
    }

    private void process(int index, List<Integer> tempList, List<List<Integer>> list, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            Integer v = candidates[i];
            tempList.add(v);
            process(i, tempList, list, target - v, candidates);
            tempList.remove(v);
        }
    }
}
