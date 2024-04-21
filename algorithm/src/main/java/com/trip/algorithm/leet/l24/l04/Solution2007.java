package com.trip.algorithm.leet.l24.l04;

import java.util.*;

/**
 * @author xbguo
 * @date 2024/4/18 15:54
 */
public class Solution2007 {
    public static void main(String[] args) {
        // int[] arr = {1, 3, 4, 2, 6, 8};
        //int[] arr = {0, 0, 0, 0};
        //int[] arr = {6, 3, 0, 1};
       // int[] arr = {2, 1, 2, 4, 2, 4};
        int[] arr = {1, 1};
        int[] originalArray = findOriginalArray1(arr);
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

    public static int[] findOriginalArray1(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[]{};
        }
        int max = -1;
        for (int i : changed) {
            max = Math.max(i, max);
        }
        int[] dp = new int[max + 1];
        for (int j = 0; j < changed.length; j++) {
            dp[changed[j]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < dp.length; j++) {
            if (dp[j] != 0) {
                int r = 2 * j;
                if (r >= dp.length || dp[j] > dp[r]) {
                    return new int[]{};
                }
                int len = j == 0 ? dp[j] / 2 : dp[j];
                for (int i = 0; i < len; i++) {
                    list.add(j);
                }
                dp[r] = dp[r] - dp[j];
                dp[j] = 0;
            }
        }
        int t = list.size();
        int[] arr = new int[t];
        for (int j = 0; j < t; j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }
}
