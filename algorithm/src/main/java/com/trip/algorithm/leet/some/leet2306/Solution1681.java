package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/28 15:40
 */
public class Solution1681 {
    public static void main(String[] args) {
        Solution1681 solution1681 = new Solution1681();
      /*  int[] nums = {1, 2, 1, 4};
        int k = 2;  */

     /*   int[] nums = {6, 3, 8, 1, 3, 1, 2, 2};
        int k = 4;*/
           int[] nums = {7,3,16,15,1,13,1,2,14,5,3,10,6,2,7,15};
        int k = 8;

        int i = solution1681.minimumIncompatibility(nums, k);
        System.out.println(i);

       /* List<List<Integer>> list = solution1681.permuteUnique(nums);
        System.out.println("----------------------");
        for (List<Integer> list1:list){
            System.out.println(list1);
        }*/
    }


    public int minimumIncompatibility(int[] nums, int k) {
        int length = nums.length;
        if (length % k != 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).boxed().forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        boolean flag = map.entrySet().stream().anyMatch(x -> x.getValue() > k);
        if (flag) {
            return -1;
        }
        Boolean[] vis = new Boolean[length];
        Arrays.fill(vis, false);
        List<Integer> list = new ArrayList<>();
        process(vis, list, nums, k);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int res = Integer.MAX_VALUE;

    private void process(Boolean[] vis, List<Integer> list, int[] nums, int k) {
        if (list.size() == nums.length) {
            check(list, k);
            return;
        }
        if (list != null && list.size() > nums.length / k) {
            if(check(list,k,nums.length)){
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);
                process(vis, list, nums, k);
                vis[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(List<Integer> list, int k, int length) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int v = 0;
        int z = length / k;
        for (int i = 0; i < list.size(); i++) {
            if (v == z) {
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(tempList);
                tempList.clear();
                List<Integer> collect = list1.stream().distinct().collect(Collectors.toList());
                if (collect.size() != list1.size()) {
                    return true;
                }
                v = 0;
                listList.add(collect);
            }
            v++;
            tempList.add(list.get(i));
        }
        return false;
    }

    private void check(List<Integer> list, int k) {
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int v = 0;
        int z = list.size() / k;
        for (int i = 0; i < list.size(); i++) {
            if (v == z) {
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(tempList);
                tempList.clear();
                List<Integer> collect = list1.stream().distinct().collect(Collectors.toList());
                if (collect.size() != list1.size()) {
                    return;
                }
                v = 0;
                listList.add(collect);
            }
            v++;
            tempList.add(list.get(i));
        }

        List<Integer> collect = tempList.stream().distinct().collect(Collectors.toList());
        if (collect.size() != tempList.size()) {
            return;
        }
        listList.add(collect);

        int cur = 0;
        for (List<Integer> integerList : listList) {
            integerList.sort((o1, o2) -> o2 - o1);
            cur += integerList.get(0) - integerList.get(integerList.size() - 1);
        }
        res = Math.min(res, cur);
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
