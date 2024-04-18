package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/4/18 15:54
 */
public class Solution2007 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 6, 8};
        // int[] arr = {0, 0, 0, 0};
        int[] originalArray = findOriginalArray(arr);
        System.out.println(Arrays.toString(originalArray));
    }

    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(changed);
        int count = 0;
        List<Integer> continList = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            if (changed[i] == 0) {
                count++;
                continue;
            }
            set.add(changed[i]);
            continList.add(changed[i]);
        }

        if ((count) % 2 != 0) {
            return new int[]{};
        }
        for (int j = 0; j < count / 2; j++) {
            list.add(0);
        }

        for (Integer t : continList) {
            if (!set.contains(t)) {
                continue;
            }
            if (set.isEmpty()) {
                break;
            }
            boolean remove = set.remove(Integer.valueOf(2 * t));
            if (!remove) {
                return new int[]{};
            }
            set.remove(t);
            list.add(t);
        }
        if (set.isEmpty()) {
            int t = list.size();
            int[] arr = new int[t];
            for (int j = 0; j < t; j++) {
                arr[j] = list.get(j);
            }
            return arr;
        }
        return new int[]{};
    }
}
