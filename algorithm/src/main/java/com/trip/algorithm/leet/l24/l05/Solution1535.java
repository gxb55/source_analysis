package com.trip.algorithm.leet.l24.l05;

import java.util.LinkedList;

public class Solution1535 {
    public static void main(String[] args) {
       /* int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int k = 2;   */

        int[] arr = {1, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        int k = 1000000000;

        int winner = getWinner(arr, k);
        System.out.println(winner);
    }

    public static int getWinner(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int t : arr) {
            list.addLast(t);
        }
        if (k >= arr.length) {
            Integer i = list.stream().max(Integer::compareTo).get();
            return i;
        }
        int last = -1;
        int t = k;
        while (k > 0) {
            Integer first = list.pollFirst();
            Integer second = list.pollFirst();
            int max = Math.max(first, second);
            int min = Math.min(first, second);
            if (max == last || last == -1) {
                k--;
            } else {
                k = t - 1;
            }
            last = max;
            list.addFirst(max);
            list.addLast(min);
        }
        return last;
    }
}
