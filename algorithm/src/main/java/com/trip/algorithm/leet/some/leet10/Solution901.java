package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/21 09:40
 * @description: Solution901
 */
public class Solution901 {
    public static void main(String[] args) {
        Solution901  solution901 = new Solution901();
        //[100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
        System.out.println(solution901.next(100));
        System.out.println(solution901.next(80));
        System.out.println(solution901.next(60));
        System.out.println(solution901.next(70));
        System.out.println(solution901.next(60));
        System.out.println(solution901.next(75));
        System.out.println(solution901.next(85));
    }


    public Solution901() {
        list = new ArrayList<>();
        dpList = new ArrayList<>();
    }
    List<Integer> list;
    List<Integer> dpList;
    public int next(int price) {
        list.add(price);
        int size = list.size();
        if (size == 1) {
            dpList.add(1);
            return 1;
        } else {
            int cur = 1;
            if (list.get(size - 1) >= list.get(size - 2)) {
                int index = dpList.get(size - 2);
                cur = cur + index;
                for (int i = size - index - 2; i >= 0; i--) {
                    if (price >= list.get(i)) {
                        cur++;
                    } else {
                        break;
                    }
                }
            }
            dpList.add(cur);
            return cur;
        }
    }
}
