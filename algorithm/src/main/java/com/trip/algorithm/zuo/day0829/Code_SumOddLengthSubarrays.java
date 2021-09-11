package com.trip.algorithm.zuo.day0829;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 */
public class Code_SumOddLengthSubarrays {
    public static void main(String[] args) {
        Code_SumOddLengthSubarrays code = new Code_SumOddLengthSubarrays();
        int[] arr = {1,4,2,5,3};
        int i = code.sumOddLengthSubarrays(arr);
        System.out.println(i);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int index = 1;
        process(arr, index * 2 + 1, list);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int sum = 0;
        for (Integer li : list) {
            sum += li;
        }
        return sum;
    }

    private void process(int[] arr, int i, List<Integer> list) {
        if(i>=arr.length){
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (j + i < arr.length) {
                for (int l = j; l < i; l++) {
                    list.add(arr[j]);
                }
            }
        }
        process(arr, i * 2 + 1, list);
    }
}
