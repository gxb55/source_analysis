package com.trip.algorithm.leet.leet75.binarylookupproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/9/1 19:08
 */
public class Solution2300 {
    public static void main(String[] args) {
        Solution2300 solution2300 = new Solution2300();
       /* int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int success = 7;*/

        int[] spells = {3, 1, 2}, potions = {8,  5, 8};
        int success = 16;
        int[] ints = solution2300.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(ints));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int length = spells.length;
        int[] res = new int[length];
        int length1 = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int cur = spells[i];
            int left = 0;
            int right = potions.length - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long midVal = potions[mid];
                long l = midVal * cur;
                if ( l>= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (index != -1) {
                res[i] = length1 - index;
            }
        }
        return res;
    }
}
