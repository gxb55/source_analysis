package com.trip.algorithm.leet.some.leet2310;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2023/10/7 16:52
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 单调栈，单调递减，如果某个值大于前面的，则前面的出栈
 */
public class Solution901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner =new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}

class StockSpanner {

    private Deque<int[]> deque;

    public StockSpanner() {
        deque = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!deque.isEmpty()) {
            int[] pop = deque.peekLast();
            if (price >= pop[0]) {
                deque.pollLast();
                count += pop[1];
            } else {
                break;
            }
        }
        deque.add(new int[]{price, count});
        return count;
    }
}