package com.trip.algorithm.leet.some.everday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年07月09日 15:31:00
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 * <p>
 * 通过次数31,581提交次数57,731
 */
public class Solution873 {
    public static void main(String[] args) {
        Solution873 solution873 = new Solution873();
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        // 4 14 18 32 50 [2,4,7,8,9,10,14,15,18,23,32,50]
          int[] arr = {2,4,7,8,9,10,14,15,18,23,32,50};
        //int[] arr = {1, 3, 7, 11, 12, 14, 18};
        int i = solution873.lenLongestFibSubseq1(arr);
        System.out.println(i);
    }

    public int lenLongestFibSubseq(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int p1 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                int x = arr[i];
                int y = arr[j];
                int res = x + y;
                if (map.containsKey(res)) {
                    p1 = Math.max(p1, process(map, arr[j], res) + 3);
                }
            }
        }

        return p1;
    }

    private int process(Map<Integer, Integer> map, int l, int r) {
        if (map.containsKey(l + r)) {
            return process(map, r, l + r) + 1;
        } else {
            return 0;
        }
    }


    public int lenLongestFibSubseq1(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int length = arr.length;
        int[][] dp = new int[length][length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int x = arr[i];
                int y = arr[j];
                Integer k = map.getOrDefault(x - y, -1);
                if (k >=0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                max = Math.max(max, dp[j][i]);
            }
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(dp[j][i]+"  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");

        return max;
    }
}
