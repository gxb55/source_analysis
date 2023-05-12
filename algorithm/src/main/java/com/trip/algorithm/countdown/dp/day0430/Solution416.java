package com.trip.algorithm.countdown.dp.day0430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年04月30日 18:37:00
 */
public class Solution416 {
    public static void main(String[] args) {
        //  int[] nums={1,5,11,5,2};
        //  int[] nums={1,2,3,5};
        // int[] nums={1,1,2,2};
        int[] nums = {14, 9, 8, 4, 3, 2};
        boolean b = canPartition1(nums);
        System.out.println(b);
    }



    public static boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int val = sum / 2;
        dp = new int[nums.length + 1][val + 1];
        return getRes(0, val, 0, nums);
    }
    static int[][] dp;
    private static boolean getRes(int cur, int val, int index, int[] nums) {
        if (index >= nums.length) {
            return false;
        }
        if (cur > val) {
            return false;
        }
        if (dp[index][cur] == 5) {
            return true;
        } else if (dp[index][cur] == 10) {
            return false;
        }
        if (cur == val) {
            return true;
        }
        boolean b = getRes(cur + nums[index], val, index + 1, nums) || getRes(cur, val, index + 1, nums);
        dp[index][cur] = b == true ? 5 : 10;
        return b;
    }

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int val = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> collect = new ArrayList<>();
            list.forEach(x -> {
                if (x > val || (x + num) > val) {

                } else {
                    collect.add(x + num);
                    collect.add(x);
                }
            });
            if (collect.contains(val)) {
                return true;
            }
            list = collect;
        }
        return false;
    }
}
