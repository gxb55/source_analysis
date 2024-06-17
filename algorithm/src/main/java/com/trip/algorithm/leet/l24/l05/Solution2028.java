package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2028 {
    public static void main(String[] args) {
       /* int[]rolls = {3,2,4,3};
        int mean = 4, n = 2; */

        int[] rolls = {1, 5, 6};
        int mean = 3, n = 4;
        int[] ints = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int sum1 = mean * (n + rolls.length);
        int res = sum1 - sum;
        if (6 * n < res || res < n) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        int i = res / n;
        int j = res % n;
        while (j != 0) {
            int i1 = 6 - i;
            int t = j - i1;
            if (t < 0) {
                list.add(i+j);
                j=0;
            } else {
                list.add(6);
                j=t;
            }
        }
        while (list.size() != n) {
            list.add(i);
        }
        int arr[] = new int[n];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }
}
