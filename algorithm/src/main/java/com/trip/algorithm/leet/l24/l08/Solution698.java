package com.trip.algorithm.leet.l24.l08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution698 {
    public static void main(String[] args) {
       /* int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4; */

       /* int[] nums = {1,1,1,1,2,2,2,2};
        int k = 2; */

        int[] nums = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;
        boolean b = canPartitionKSubsets1(nums, k);
        System.out.println(b);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        List<Integer> collect = Arrays.stream(nums).boxed().sorted((x, y) -> x - y).collect(Collectors.toList());
        Integer reduce = collect.stream().reduce(0, (x, y) -> x + y);
        if (reduce % k != 0) {
            return false;
        }
        int v = reduce / k;
        if (collect.get(collect.size() - 1) > v) {
            return false;
        }
        while (!collect.isEmpty()) {
            boolean flag = false;
            List<Integer> list = new ArrayList<>();
            y:
            for (int i = 1; i < collect.size(); i++) {
                int right = collect.size() - i;
                int cur = 0;
                for (int j = right; j < collect.size(); j++) {
                    cur = cur + collect.get(j);
                    if (cur > v) {
                        return false;
                    }
                    list.add(collect.get(j));
                }
                if (cur == v) {
                    flag = true;
                    break y;
                }
                for (int j = 0; j < right; j++) {
                    cur = cur + collect.get(j);
                    list.add(collect.get(j));
                    if (cur == v) {
                        flag = true;
                        break y;
                    }
                }
            }
            if (flag) {
                list.stream().forEach(x -> System.out.print(x + ","));
                list.stream().forEach(x -> collect.remove(x));
            } else {
                return false;
            }
        }
        return true;

    }

    public static boolean canPartitionKSubsets1(int[] nums, int k) {
        List<Integer> collect = Arrays.stream(nums).boxed().sorted((x, y) -> x - y).collect(Collectors.toList());
        Integer reduce = collect.stream().reduce(0, (x, y) -> x + y);
        if (reduce % k != 0) {
            return false;
        }
        int v = reduce / k;
        if (collect.get(collect.size() - 1) > v) {
            return false;
        }
        int[] arr = new int[k];
        //  System.out.println(collect);
        //  System.out.println("v:" + v + ";" + "k:" + k);
        return process(collect, arr, 0, v);

    }

    private static boolean process(List<Integer> collect, int[] arr, int index, int v) {
        if (index == collect.size()) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) {
                continue;
            }
            Integer i1 = collect.get(index);
            if ((i1 + arr[i]) > v) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            arr[i] += i1;
            boolean process = process(collect, arr, index + 1, v);
            if (process) {
                return true;
            }
            arr[i] -= i1;
        }
        return false;
    }

    private static boolean process(List<Integer> collect, int v, int k, Set<Integer> set,
                                   int index, int curVal, int curCount) {
        if (curVal == v && curCount == k) {
            System.out.println(set);
            set.stream().forEach(x -> collect.remove(collect.get(x)));
            set.clear();
            return process(collect, v, k, set, 0, 0, 0);
        }
        if (curCount >= k && curVal != v) {
            return false;
        }
        if (curVal > v) {
            return false;
        }
        boolean flag = false;
        for (int i = index; i < collect.size(); i++) {
            Integer j = collect.get(i);
            set.add(i);
            flag = flag || process(collect, v, k, set, i + 1, curVal + j, curCount + 1);

            set.remove(i);
        }
        return flag;
    }
}
