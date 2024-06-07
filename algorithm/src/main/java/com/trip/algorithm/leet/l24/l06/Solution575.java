package com.trip.algorithm.leet.l24.l06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/6/3 19:57
 * @description TODO
 */
public class Solution575 {
    public static void main(String[] args) {

    }

    public int distributeCandies(int[] candyType) {
        int i = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        int t = 0;
        for (int j = 0; j < candyType.length && i > 0; j++) {
            int v = candyType[j];
            if (set.add(v)) {
                i--;
                t++;
            }
        }
        return t;
    }
}
