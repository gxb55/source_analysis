package com.trip.algorithm.leet.some.leet2302;


import java.util.Arrays;

/**
 * @author amount[0]bguo
 * @createTime 2023年02月11日 21:32:00
 */
public class Solution2335 {
    public static void main(String[] args) {
        //  int[] amount = {1,4,2};
        int[] amount = {5, 4, 4};
        int i = Solution2335.fillCups(amount);
        System.out.println(i);
    }

    public static int fillCups(int[] amount) {
        int count = 0;
        int t;
        Arrays.sort(amount);
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            t = 0;
            Arrays.sort(amount);
            if (amount[2] > 0) {
                amount[2]--;
                t++;
            }
            if (amount[1] > 0) {
                amount[1]--;
                t++;
            }
            if (amount[0] > 0 && t < 2) {
                amount[0]--;
            }
            count++;
        }
        return count;
    }
}
