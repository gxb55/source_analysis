package com.trip.algorithm.leet.leet75.binarylookupproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/9/1 19:08
 */
public class Solution2300 {
    public static void main(String[] args) {

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int length = spells.length;
        int[] res = new int[length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int cur=spells[i];
            int left=0;
            int right=potions.length-1;
            while (left<right){
                int mid=left+(right-left)/2;
            }
        }
        return res;
    }
}
