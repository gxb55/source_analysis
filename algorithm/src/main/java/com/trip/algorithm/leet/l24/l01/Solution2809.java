package com.trip.algorithm.leet.l24.l01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2809 {
    public static void main(String[] args) {
        Solution2809 solution2809 = new Solution2809();
        Integer[] num1 = {1, 2, 3};
        Integer[] num2 = {1, 2, 3};
        int t = 4;
        int i = solution2809.minimumTime1(List.of(num1), List.of(num2), t);
        System.out.println(i);
        System.out.println(solution2809.minimumTime(List.of(num1), List.of(num2), t));
    }

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int s1 = nums1.stream().mapToInt(z -> z).sum();
        int s2 = nums2.stream().mapToInt(z -> z).sum();
        List<List<Integer>> list = new ArrayList<>();
        int t = nums1.size();
        for (int i = 0; i < t; i++) {
            list.add(Arrays.asList(nums2.get(i), nums1.get(i)));
        }
        Collections.sort(list, (x1, x2) -> x1.get(0) - x2.get(0));
        int[][] dp = new int[t + 1][t + 1];
        for (int i = 1; i <= t; i++) {
            Integer b = list.get(i - 1).get(0);
            Integer a = list.get(i - 1).get(1);

            for (int j = i; j > 0; --j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + a + j * b);
            }
        }
        for (int i = 0; i <= t; i++) {
            int sum = s1 + s2 * i;
            if ((sum - dp[t][i]) <= x) {
                return i;
            }
        }
        return -1;
    }

    public int minimumTime1(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        int[][] dp = new int[n + 1][n + 1];
        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            nums.add(Arrays.asList(b, a));
            s1 += a;
            s2 += b;
        }
        Collections.sort(nums, (o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));

        for (int j = 1; j <= n; ++j) {
            int b = nums.get(j - 1).get(0), a = nums.get(j - 1).get(1);
            for (int i = j; i > 0; --i) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - 1] + i * b + a);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (s2 * i + s1 - dp[n][i] <= x) {
                return i;
            }
        }
        return -1;
    }

}
