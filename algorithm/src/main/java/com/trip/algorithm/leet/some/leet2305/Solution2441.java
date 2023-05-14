package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年05月14日 21:59:00
 */
public class Solution2441 {
    public static void main(String[] args) {
        int maxK = findMaxK(null);
        System.out.println(maxK);
    }

    public  static int findMaxK(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer < 0) {
                return -1;
            }
            if(list.contains(-integer)){
                return integer;
            }
        }
        return -1;
    }
}
