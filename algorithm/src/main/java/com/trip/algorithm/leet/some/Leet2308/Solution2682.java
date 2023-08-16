package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/8/16 10:29
 */
public class Solution2682 {
    public static void main(String[] args) {
        //int n = 5, k = 2;
        //int n = 4, k = 4;
        int n = 6, k = 1;
        int[] ints = circularGameLosers(n, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                list.add(i);
            }
            arr[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        int t = k;
        int c = 1;
        set.add(0);
        while (true) {
            t = k * c;
            cur = cur + t;
            cur = cur % n;
            if (!set.add(cur)) {
                break;
            }
            c++;
        }
        list.removeAll(set);
        int[] res = new int[list.size()];
        int i = 0;
        for (int x : list) {
            res[i] = x + 1;
            i++;
        }
        return res;
    }
}
