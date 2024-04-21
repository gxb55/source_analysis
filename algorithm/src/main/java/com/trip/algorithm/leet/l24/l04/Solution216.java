package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        //  int k = 3, n = 7;
        int k = 9, n = 45;
        List<List<Integer>> list = solution216.combinationSum3(k, n);
        list.forEach(x -> System.out.println(x));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(0, tempList, list, n, arr, k);
        return list;
    }

    private void process(int index, List<Integer> tempList, List<List<Integer>> list, int target, int[] arr, int k) {
        if (target == 0 && tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (index >= arr.length) {
            return;
        }
        if (tempList.size() >= k) {
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            Integer v = arr[i];
            tempList.add(v);
            process(i + 1, tempList, list, target - v, arr, k);
            tempList.remove(v);
        }
    }
}
