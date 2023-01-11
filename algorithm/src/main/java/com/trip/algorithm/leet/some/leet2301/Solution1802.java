package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @createTime 2023年01月04日 20:41:00
 * 1802. 有界数组中指定下标处的最大值
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 * <p>
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 * <p>
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 * 通过次数18,369提交次数50,731
 */
public class Solution1802 {
    public static void main(String[] args) {
        Solution1802 solution1802 = new Solution1802();
   //     int n = 4, index = 2, maxSum = 6;
      //  int n = 6, index = 1,  maxSum = 10;
        int n = 6, index = 2,  maxSum = 931384943;
        int i = solution1802.maxValue(n, index, maxSum);
        System.out.println(i);
    }

    public int maxValue(int n, int index, int maxSum) {
        long right = maxSum;
        long left = 0;
        long res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            boolean flag = check(mid, n, index, maxSum);
            if (flag) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) res;
    }

    private boolean check(long mid, int n, int index, int maxSum) {
        int left = index - 1;
        int right = index + 1;
        long leftSum = 0;
        long rightSum = 0;
        long tempMid = mid - 1;
        if (left >= 0) {
            int len = left + 1;
            if (tempMid <= 1) {
                leftSum = len;
            } else {
                if (len > tempMid) {
                    leftSum = (1 + tempMid) * (tempMid) / 2 + len - tempMid;
                } else {
                    leftSum = (tempMid + (tempMid - len + 1)) * len / 2;
                }
            }

        }
        if (right < n) {
            int len = n - right;
            if (tempMid <= 1) {
                rightSum = len;
            } else {
                if (len > tempMid) {
                    rightSum = (1 + tempMid) * (tempMid) / 2 + len - tempMid;
                } else {
                    rightSum = (tempMid + (tempMid - len + 1)) * len / 2;
                }
            }

        }
        return maxSum >= rightSum + leftSum + mid;
    }
}
