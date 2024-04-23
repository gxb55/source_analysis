package com.trip.algorithm.leet.l24.l04;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/4/23 09:39
 */
public class Solution1052 {
    public static void main(String[] args) {
        Solution1052 solution1052 = new Solution1052();
      /*  int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3; */

        int[] customers = {2,6,6,};
        int[] grumpy = {0,0,1,1};
        int minutes = 1;

        int i = solution1052.maxSatisfied(customers, grumpy, minutes);
        System.out.println(i);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = 0;
        int temp=minutes;
        while (true){
            while (right<customers.length&&temp==0){
                if(grumpy[right]==1){
                    temp--;
                }
                right++;
            }
        }
        int left = -1;
        int right = minutes + 1;
        if (minutes >= grumpy.length) {
            return Arrays.stream(customers).sum();
        }
        int sum = 0;
        for (int i = 0; i < right; i++) {
            sum += customers[i];
        }
        left++;
        for (int i = right; i < customers.length; i++, left++) {
            sum += customers[i];
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
        }
        return sum;
    }
}
