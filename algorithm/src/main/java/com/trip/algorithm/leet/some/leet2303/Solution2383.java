package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年03月13日 21:27:00
 */
public class Solution2383 {
    public static void main(String[] args) {
       /* int initialEnergy = 2, initialExperience = 4;
        int[] energy = {1}, experience = {3};*/

        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1,4}, experience = {2,5};

      /*  int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1, 4, 3, 2}, experience = {2, 6, 3, 1};*/


        int i = minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(i);
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = Arrays.stream(energy).sum();
        int res = 0;
        if (sum >= initialEnergy) {
            res = res + (sum - initialEnergy) + 1;
        }
        int init = initialExperience;
        for (int x : experience) {
            if (x >= init) {
                res = res + (x - init) + 1;
                init += (x - init) + 1;
            }
            init += x;

        }
        return res;
    }
}
