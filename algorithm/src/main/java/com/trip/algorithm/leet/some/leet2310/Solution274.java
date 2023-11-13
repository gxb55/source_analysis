package com.trip.algorithm.leet.some.leet2310;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年10月29日 09:47:00
 */
public class Solution274 {
    public static void main(String[] args) {
        //int[] arr = {3, 0, 6, 1, 5};
        int[] arr = {1,3,1};
        int i = hIndex(arr);
        System.out.println(i);
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        List<Integer> collect = Arrays.stream(citations).boxed().collect(Collectors.toList());

        for (int i = len; i > 0; i--) {
            int finalI = i;
            long count = collect.stream().filter(x -> x >= finalI).count();
            if (count >= i) {
                return  i;
            }
        }
        return 0;
    }
}
