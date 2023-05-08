package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2023年03月26日 20:15:00
 * 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * <p>
 * <p>
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
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 * 通过次数46,687提交次数176,832
 */
public class Solution862 {
    public static void main(String[] args) {
      /*  int[] nums = {2, -1, 2};
        int k = 3;*/

       /* int[] nums = {17,85,93,-45,-21};
        int k = 150;*/

      /*  int[] nums = {1};
        int k = 1; */

      /*  int[] nums = {77,19,35,10,-14};
        int k = 19;*/

        int[] nums = {84, -37, 32, 40, 95};
        int k = 167;


        int i = shortestSubarray(nums, k);
        System.out.println(i);
    }
    public int shortestSubarray1(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i]; // 计算前缀和
        }
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i <= n; ++i) {
            long curS = s[i];
            while (!q.isEmpty() && curS - s[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.pollFirst()); // 优化一
            }
            while (!q.isEmpty() && s[q.peekLast()] >= curS) {
                q.pollLast(); // 优化二
            }
            q.addLast(i);
        }
        return ans > n ? -1 : ans;
    }

    public static int shortestSubarray(int[] nums, int k) {
        if (nums.length == 1 && nums[0] == k) {
            return 1;
        }
        int res=Integer.MAX_VALUE;
        int sum=0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum=sum+num;
            if(!list.isEmpty()){
                if(sum<list.peekLast()){
                    list.pollLast();
                }
                if((sum-list.peekFirst())>=k){
                    res=Math.min(res,list.size()+1);

                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
