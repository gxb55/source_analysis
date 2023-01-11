package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/26 18:38
 * @description: Solution862
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution862 {
    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
       /* int[] arr = {1};
        int k = 1;*/
       /* int[] arr = {1, 2};
        int k = 4; */

      /*  int[] arr = {2, -1, 2};
        int k = 3; */

       /* int[] arr = {17, 85, 93, -45, -21};
        int k = 150;*/
      /*  int[] arr = {-28,81,-20,28,-29};
        int k = 89;*/

        /*int[] arr = {77,19,35,10,-14};
        int k = 19;*/
        int[] arr = {84, -37, 32, 40, 95};
        int k = 167;
        int i = solution862.shortestSubarray1(arr, k);
        System.out.println(i);
    }

    public int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (sum < k) {
                sum = sum + nums[right];
                list.add(nums[right]);
                right++;
            } else {
                sum = sum - nums[left];
                list.remove(0);
                left++;
            }
            if (sum >= k) {
                min = Math.min(min, list.size());
            }
            if (left >= nums.length || right >= nums.length) {
                break;
            }
            min = Math.min(min, check(list,k,min));
        }
        min = Math.min(min, check(list,k,min));
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int check(List<Integer> list, int k, int min) {
        List<Integer> list1 = new ArrayList<>();
        list.stream().forEach(x->list1.add(x));
        while (!list1.isEmpty()) {
            int x = 0;
            for (Integer integer : list1) {
                x = x + integer;
            }
            if (x >= k) {
                min = Math.min(min, list1.size());
            }
            list1.remove(0);
        }
        return min;
    }

    public int shortestSubarray1(int[] nums, int k) {
        int[][] dp = new int[nums.length][2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i][0] = nums[0];
                dp[i][1] = 1;
            } else {
                if ((nums[i] + dp[i - 1][0]) > nums[i]) {
                    dp[i][0] = nums[i] + dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][0] = nums[i];
                    dp[i][1] = 1;
                }
            }
            if(dp[i][0]>=k){
                min=Math.min(min,dp[i][1]);
            }
            /*int cur = dp[i][0];
            int begin = i - dp[i][1] + 1;
            while (begin != i) {
                min = Math.min(min, i - begin + 1);
                cur = cur - nums[begin];
                begin++;
            }*/
        }
        return min;
    }

    public int shortestSubarray2(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }


}
