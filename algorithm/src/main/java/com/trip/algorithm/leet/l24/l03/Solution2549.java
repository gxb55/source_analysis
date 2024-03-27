package com.trip.algorithm.leet.l24.l03;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution2549 {
    public static void main(String[] args) {
        Solution2549 solution2549 =new Solution2549();
      //  int n=5;
        int n=3;
        int i = solution2549.distinctIntegers(n);
        System.out.println(i);
    }

    /**
     * 1 <= i <= n 且满足 x % i == 1
     *
     * @param n
     * @return
     */
    public int distinctIntegers(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(n);
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (!list.isEmpty()) {
            int len = list.size();
            while (len > 0) {
                Integer i = list.pollFirst();
                for (int j = 1; j < i; j++) {
                    if (i % j == 1) {
                        list.addLast(j);
                        set.add(j);
                    }
                }
                len--;
            }
        }
        return set.size();
    }
}
