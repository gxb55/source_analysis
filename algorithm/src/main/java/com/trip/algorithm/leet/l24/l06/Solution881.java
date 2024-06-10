package com.trip.algorithm.leet.l24.l06;

import java.util.Arrays;

public class Solution881 {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        for (; l <= r; ) {
            if ((people[r] + people[l]) > limit) {
                r--;
                count++;
            } else {
                l++;
                r--;
                count++;
            }
        }
        return count;
    }
}
