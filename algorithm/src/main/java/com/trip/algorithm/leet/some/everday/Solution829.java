package com.trip.algorithm.leet.some.everday;

/**
 * @author xbguo
 * @createTime 2022年06月03日 10:33:00
 * 829. 连续整数求和
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * <p>
 * 输入: n = 9
 * 输出: 3
 * 解释: 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * <p>
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109​​​​​​​
 */
public class Solution829 {
    public static void main(String[] args) {
        Solution829 solution829 = new Solution829();
        int val = 4;
      //  int val = 855204;
       // int val = 8504986;
        //int val = 1;
        int i = solution829.consecutiveNumbersSum1(val);
        int v = solution829.consecutiveNumbersSum2(val);
        System.out.println(i);
        System.out.println(v);
    }

    public int consecutiveNumbersSum(int n) {
        int sum = 1;
        int len = (n / 2) + 1;
        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = i; j < len; j++) {
                cur += j;
                if (cur == n) {
                    sum++;
                } else if (cur > n) {
                    break;
                }
            }
        }
        return sum;
    }

    public int consecutiveNumbersSum1(int n) {
        int sum = 1;
        int len = (n / 2) + 2;
        len = len > n ? n : len;
        long cur = 0;
        int[] dp = new int[100000];
        dp[0]=1;
        for (int i = 0; i < len; i++) {
            cur += i;
            if (dp[(int) (cur - n)]!=0) {
                sum++;
            }
            dp[(int) cur]=i;
        }
        return sum;
    }


    public int consecutiveNumbersSum2(int n) {
        int sum = 1;
        int len = (n / 2) + 2;
        len = len > n ? n : len;
        sum = len == n ? 0 : 1;
        int left = 1;
        int right = 1;
        int curSum = 1;
        while (true) {
            if (curSum == n && right <= n) {
                sum++;
                right++;
                curSum = curSum + right;
            } else if (curSum < n && right <= n) {
                right++;
                curSum = curSum + right;
            } else if (curSum > n) {
                curSum = curSum - left;
                left++;
            } else {
                break;
            }
            if (left >= right) {
                if (curSum == n ) {
                    sum++;
                }
                break;
            }

        }
        return sum;
    }
}
