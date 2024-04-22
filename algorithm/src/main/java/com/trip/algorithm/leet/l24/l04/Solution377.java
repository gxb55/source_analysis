package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/4/22 16:09
 */
public class Solution377 {
    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        int[] nums = {1, 2, 3};
        int target = 4;
        int i = solution377.combinationSum42(nums, target);
        System.out.println(i);
    }

    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j < dp.length; j++) {
            for (int x : nums) {
                if (j >= x) {
                    dp[j] = dp[j - x] + dp[j];
                }
            }
        }
        return dp[target];
    }

    public int combinationSum41(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < dp[i].length; j++) {
                int last = 0;
                if (i != 0) {
                    last = dp[i - 1][j];
                }
                int v = nums[i];
                if ((j - v) >= 0) {
                    dp[i][j] = dp[i][j - v] + last;
                } else {
                    dp[i][j] = last;
                }

            }
        }

        return dp[nums.length - 1][target];
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(nums, 0, list, tempList, target);
        return list.size();
    }

    private void process(int[] nums, int index, List<List<Integer>> list, List<Integer> tempList, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            Integer val = nums[i];
            tempList.add(val);
            process(nums, i, list, tempList, target - val);
            tempList.remove(val);
        }
    }
}
