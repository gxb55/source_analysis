package com.trip.algorithm.leet.leet75.monotonestack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月05日 11:09:00
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 */
public class Solution901 {
    public static void main(String[] args) {
        StockSpanner1 spanner = new StockSpanner1();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }
}

class StockSpanner1 {
    Deque<int[]> deque;

    public StockSpanner1() {
        deque = new ArrayDeque<>();
    }

    public int next(int price) {
        if (deque.isEmpty()) {
            deque.add(new int[]{price, 1});
            return 1;
        }
        int sum = 1;
        while (!deque.isEmpty() && deque.peekLast()[0] <= price) {
            sum = sum + deque.pollLast()[1];
        }
        deque.add(new int[]{price, sum});
        return sum;// 栈优先队列
    }
}

class StockSpanner {
    List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int max = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (price >= list.get(i)) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }
}