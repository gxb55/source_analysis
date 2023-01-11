package com.trip.algorithm.codethink.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @auther: xbguo
 * @date: 2022/11/8 16:38
 * @description: Solution15
 */
public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        // int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {-2, 0, 1, 1, 2};
        List<List<Integer>> lists = solution15.threeSum1(arr);
        for (List<Integer> temp : lists) {
            System.out.println(temp);
        }
        System.out.println("===========");
        lists = solution15.threeSum(arr);
        for (List<Integer> temp : lists) {
            System.out.println(temp);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                List<Integer> integers = map.get(num);
                integers.add(i);

            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                map.put(num, list1);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                break;
            }
            int res = 0 - num;
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                int cur = res - num1;
                if (map.containsKey(cur)) {
                    List<Integer> integers = map.get(cur);
                    int finalJ = j;
                    List<Integer> collect = integers.stream().filter(x -> x > finalJ).collect(Collectors.toList());
                    if (collect != null) {
                        for (Integer integer : collect) {
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[integer]);
                            list.add(list1);
                        }
                    }
                }
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int r = nums.length - 1;
            int j = i + 1;
            while (j < r) {
                int val = nums[i] + nums[j] + nums[r];
                if (val > 0) {
                    r--;
                } else if (val == 0) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[r]);
                    list.add(list1);
                    int curJ = nums[j];
                    while (j < r && curJ == nums[j]) {
                        j++;
                    }
                    int curR = nums[r];
                    while (j < r && curR == nums[r]) {
                        r--;
                    }

                } else {
                    j++;
                }
            }

        }
        return list;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


}
