package com.trip.algorithm.leet.some.leet11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/11/23 09:38
 * @description Solution1742
 */
public class Solution1742 {
    public static void main(String[] args) {
        Solution1742 solution1742 = new Solution1742();
      //  int lowLimit = 1, highLimit = 10;
        int lowLimit = 5, highLimit = 15;
        int i = solution1742.countBalls(lowLimit, highLimit);
        System.out.println(i);
        System.out.println("======================");

        int t=12458303;
        while (t != 0) {
            System.out.println(t%10);
            t = t / 10;
        }
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int t = i;
            int res = 0;
            while (t != 0) {
                res = res + t % 10;
                t = t / 10;
            }

            Integer orDefault = map.getOrDefault(res, 0);
            map.put(res, orDefault + 1);
            max = Math.max(max, orDefault + 1);
        }
        return max;
    }
}
