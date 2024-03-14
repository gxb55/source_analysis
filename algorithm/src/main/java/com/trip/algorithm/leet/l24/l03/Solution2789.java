package com.trip.algorithm.leet.l24.l03;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2024/3/14 19:05
 * @description TODO
 */
public class Solution2789 {
    public static void main(String[] args) {
         int[] arr = {2, 3, 7, 9, 3};
        //  int[] arr = {5,3,3};
      //  int[] arr = {40, 15, 35, 98, 77, 79, 24, 62, 53, 84, 97, 16, 30, 22, 49};
        Solution2789 solution2789 = new Solution2789();
        long l = solution2789.maxArrayValue(arr);
        System.out.println(l);
    }

    public long maxArrayValue(int[] nums) {
        LinkedList<Long> list = new LinkedList<>();
        for (int x : nums) {
            list.add((long) x);
        }
        boolean flag = true;
        while (flag) {
            LinkedList<Long> list1 = new LinkedList<>();
            flag = false;
            while (!list.isEmpty()) {
                Long poll = list.pollLast();
                if (!list.isEmpty()) {
                    Long peek = list.peekLast();
                    if (poll >= peek) {
                        list.pollLast();
                        list.addLast(peek + poll);
                        flag = true;
                        continue;
                    }
                }
                list1.add(poll);
            }
            Collections.reverse(list1);
            list = list1;
        }
        Long l = list.stream().max((x, y) -> y >= x ? -1 : 1).get();
        return l;
    }

}
