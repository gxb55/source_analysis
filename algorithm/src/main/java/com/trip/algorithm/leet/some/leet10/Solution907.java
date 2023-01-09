package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/28 10:28
 * @description: 907
 * 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * <p>
 * <p>
 * 通过次数26,319提交次数72,492
 */
public class Solution907 {
    public static void main(String[] args) {
        Solution907 solution907 = new Solution907();
        //int[] arr = {3, 1, 2, 4};
        int[] arr = {11, 81, 94, 43, 3};
        int i = solution907.sumSubarrayMins1(arr);
        System.out.println(i);
    }

    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                int cur = arr[j];
                min = Math.min(min, cur);
                sum = sum + min;
            }
            sum = sum % 1000000007;
        }
        return sum;
    }

    public int sumSubarrayMins1(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            int cur = arr[i];
            if (i == 0) {
                list1.add(cur);
            } else {
                list1.add(cur);
                List<Integer> integers = list.get(i - 1);
                integers.stream().forEach(x -> {
                    int a = cur;
                    if (x < cur) {
                        a = x;
                    }
                    list1.add(a);
                });
            }
            list.add(list1);
            sum = sum + list1.stream().mapToInt(x -> Integer.valueOf(x)).sum();
            sum = sum % 1000000007;
        }
        return sum;
    }

    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }

}
