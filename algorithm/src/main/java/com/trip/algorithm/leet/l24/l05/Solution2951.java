package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/5/28 17:00
 * @description TODO
 */
public class Solution2951 {

    public static void main(String[] args) {

    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int i1 = mountain[i];
            if (i1 > mountain[i - 1] && mountain[i + 1] < i1) {
                list.add(i);
            }
        }
        return list;
    }

}
