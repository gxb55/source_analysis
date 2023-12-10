package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1052 {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5}, grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        Solution1052 solution1052 = new Solution1052();
        int i = solution1052.maxSatisfied(customers, grumpy, minutes);
        System.out.println(i);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers.length == minutes) {
            return Arrays.stream(customers).sum();
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            list1.add(sum);
        }
        sum = 0;
        for (int i = customers.length - 1; i >= 0; i--) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            list2.add(sum);
        }
        Collections.reverse(list2);
        int max = 0;
        int cur = 0;
        for (int i = 0; i < minutes; i++) {
            cur += customers[i];
        }
        max = Math.max(max, cur + list2.get(minutes));

        for (int i = minutes; i < customers.length; i++) {
            cur = cur - customers[i - minutes];
            cur = cur + customers[i];
            int left = list1.get(i - minutes);
            int right = 0;
            if (i != customers.length - 1) {
                right = list2.get(i + 1);
            }
            max = Math.max(max, cur + left + right);
        }
        return max;
    }
}
