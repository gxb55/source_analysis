package com.trip.algorithm.codethink.stackcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/11/17 10:59
 * @description Solution347
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Solution347 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = solution347.topKFrequent(nums,k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        /*Arrays.sort(nums);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            return y[1] - x[1];
        });*/
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer x : nums) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int[] arr = new int[k];
        k--;
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : collect) {
            arr[k] = entry.getKey();
            k--;
            if (k < 0) {
                break;
            }
        }
        return arr;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer integer = map.get(i);
            if (integer == null) {
                map.put(i, 1);
            } else {
                map.put(i, integer + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                Map.Entry<Integer, Integer> peek = queue.peek();
                if (entry.getValue() > peek.getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            arr[index] = queue.poll().getKey();
            index++;
        }
        return arr;
    }
}
