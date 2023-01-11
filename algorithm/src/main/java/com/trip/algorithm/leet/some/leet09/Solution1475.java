package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/9/1  9:58
 * @description Solution1475
 */
public class Solution1475 {
    public static void main(String[] args) {
        Solution1475 solution1475 = new Solution1475();
       // int[] prices = {8,4,6,2,3};
      //  int[] prices = {1,2,3,4,5};
        int[] prices = {10,1,1,6};
        int[] ints = solution1475.finalPrices(prices);
        System.out.println(Arrays.toString(ints));
    }

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (val >= prices[j]) {
                    val = val - prices[j];
                    break;
                }
            }
            res[i] = val;
        }
        return res;
    }
}
