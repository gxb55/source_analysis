package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年05月15日 21:02:00
 */
public class Leet_2248 {
    public static void main(String[] args) {
        Leet_2248 leet_2248 = new Leet_2248();
        //int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
       // int[][] nums = {{1,2,3},{4,5,6}};
        int[][] nums = {{1,2,3}};
        List<Integer> intersection = leet_2248.intersection(nums);
        System.out.println(intersection);
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        if (length == 1) {
            Arrays.sort(nums[0]);
            Arrays.stream(nums[0]).forEach(x -> list.add(x));
            return list;
        }
        int[] num = nums[0];
        for (int j = 0; j < num.length; j++) {
            boolean flag = true;
            int i1 = num[j];
            for (int i = 1; i < length; i++) {
                OptionalInt any = Arrays.stream(nums[i]).filter(x -> x == i1).findAny();
                if (!any.isPresent()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i1);
            }
        }
        return list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    }
}
