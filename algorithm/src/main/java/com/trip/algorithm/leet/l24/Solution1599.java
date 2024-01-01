package com.trip.algorithm.leet.l24;

/**
 * 按照题意模拟即可，没有特殊的算法，O（1）的时间复杂度
 */
public class Solution1599 {
    public static void main(String[] args) {
        Solution1599 solution1599 = new Solution1599();

        /*int[] customers = {10, 9, 6};
        int boardingCost = 6, runningCost = 4;*/

        int[] customers = {10, 10, 6, 4, 7};
        int boardingCost = 3, runningCost = 8;
        int i = solution1599.minOperationsMaxProfit(customers, boardingCost, runningCost);
        System.out.println(i);
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int cur = 0;
        int t = 0;
        int sum = 0;
        int i = 1;
        int res = 1;
        for (; i <= customers.length; i++) {
            int customer = customers[i-1];
            cur += customer;
            if (cur >= 4) {
                cur = cur - 4;
                t += 4;
            } else {
                t += cur;
                cur = 0;
            }
            int val = t * boardingCost - runningCost * (i);
            System.out.println(val);
            if (val > sum) {
                res = i;
            }
            sum = Math.max(sum, val);

        }
        while (cur > 0) {
            if (cur >= 4) {
                cur = cur - 4;
                t += 4;
            } else {
                t += cur;
                cur = 0;
            }

            int val = t * boardingCost - runningCost * (i);
            System.out.println(val);
            if (val > sum) {
                res = i;
            }
            sum = Math.max(sum, val);
            i++;
        }
        if (sum <= 0) {
            return -1;
        }
        return res;
    }
}
