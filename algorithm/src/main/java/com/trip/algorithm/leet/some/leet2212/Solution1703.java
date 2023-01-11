package com.trip.algorithm.leet.some.leet2212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年12月18日 09:45:00
 */
public class Solution1703 {
    public static void main(String[] args) {
       /* int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;*/
      /*  int[] nums = {1, 0, 0, 0, 0, 0, 1, 1};
        int k = 3;*/
       /* int[] nums = {1, 1, 0, 1};
        int k = 2;*/

      /*  int[] nums = {1,0,0,1,0,1,1,1,0,1,1};
        int k = 7;*/
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0};
        int k = 13;
        Solution1703 solution1703 = new Solution1703();
        int i = solution1703.minMoves1(nums, k);
        System.out.println(i);
        System.out.println(solution1703.minMoves(nums, k));
    }

    public int minMoves(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[nums.length];
        boolean flag = false;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                if (flag) {
                    len++;
                } else {
                    flag = true;
                    len = 1;
                }
                if (len >= k) {
                    return 0;
                }
                list.add(i);
            } else {
                flag = false;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer leftIndex = list.get(i);
            Integer rightIndex = list.get(i);

            int left = i - 1;
            int right = i + 1;
            int res = k - 1;
            int max = 0;
            while (res > 0) {
                if (left >= 0 && right < list.size()) {
                    if ((leftIndex - list.get(left)) > (list.get(right) - rightIndex)) {
                        max = max + (leftIndex - list.get(left) - 1);
                        left--;
                        leftIndex--;
                    } else {
                        max = max + (list.get(right) - rightIndex - 1);
                        right++;
                        rightIndex++;
                    }
                    res--;
                } else if (left >= 0 && right >= list.size()) {
                    max = max + (leftIndex - list.get(left) - 1);
                    left--;
                    leftIndex--;
                    res--;
                } else if (right < list.size() && left < 0) {
                    max = max + (list.get(right) - rightIndex - 1);
                    right++;
                    rightIndex++;
                    res--;
                } else {
                    break;
                }
            }
            if (res == 0) {
                dp[i] = max;
                result = Math.min(result, max);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(nums));
        return result;
    }

    public int minMoves1(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                list.add(i);
            }
        }
        int sum = 0;
        int mid1 = (k / 2);
        for (int i = 0; i < k; i++) {
            sum = sum + Math.abs(list.get(mid1) - list.get(i));
        }
        int res = sum;
        for (int i = 0; i + k < list.size(); i++) {
            int mid = i + (k / 2);
            sum = sum - Math.abs(list.get(mid) - list.get(i));

            sum = sum + Math.abs(list.get(mid + 1) - list.get(i + k));

            sum = sum + (k/2) * (list.get(mid + 1) - list.get(mid));
            sum = sum - (k - (k/2) - 1) * (list.get(mid + 1) - list.get(mid));
            res = Math.min(res, sum);
        }
        for (int i = 0; i < k; i++) {
            res -= Math.abs(i-k/2);
        }
        return res;
    }
}
