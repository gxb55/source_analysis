package com.trip.algorithm.leet.l24.l04;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/4/23 09:39
 */
public class Solution1052 {
    public static void main(String[] args) {
        Solution1052 solution1052 = new Solution1052();
       /* int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;*/

        int[] customers = {2, 6, 6,9};
        int[] grumpy = {0, 0, 1, 1};
        int minutes = 1;

        int i = solution1052.maxSatisfied1(customers, grumpy, minutes);
        System.out.println(i);
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        if (minutes >= grumpy.length) {
            return Arrays.stream(customers).sum();
        }
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int max = sum;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    sum -= customers[i - minutes];
                }
            }
            max = Math.max(sum, max);
        }
        return max;

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (minutes >= grumpy.length) {
            return Arrays.stream(customers).sum();
        }
        int left = 0;
        int right = 0;
        int temp = minutes;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int max = sum;
        while (true) {
            while (right < customers.length && temp > 0) {
                if (grumpy[right] == 1) {
                    temp--;
                    sum += customers[right];
                }
                right++;
            }
            max = Math.max(max, sum);
            if (right >= customers.length) {
                break;
            }
            while (left < right && temp == 0) {
                if (grumpy[left] == 1) {
                    temp++;
                    sum -= customers[left];
                }
                left++;
            }
        }

        return max;
    }
}
