package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/7 13:57
 */
public class Solution2611 {
    public static void main(String[] args) {
       /* int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 1; */

        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 1;
        int i = miceAndCheese(reward1, reward2, k);
        System.out.println(i);
    }

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        if (k == reward1.length) {
            return Arrays.stream(reward1).sum();
        }
        List<int[]> list = new ArrayList<>();
        int[] diff = new int[reward1.length];
        for (int i = 0; i < diff.length; i++) {
            list.add(new int[]{i, reward1[i] - reward2[i]});
        }
        int sum = 0;
        List<int[]> collect = list.stream().sorted((x, y) -> y[1] - x[1]).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            sum += reward1[collect.get(i)[0]];
        }
        for (int i = k; i < reward2.length; i++) {
            sum += reward2[collect.get(i)[0]];
        }
        return sum;
    }
}
