package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @createTime 2023年04月10日 22:44:00
 */
public class Solution901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] arr = {100,80,60,70,60,75,85};
        for (int t : arr) {
            System.out.println(stockSpanner.next(t));
        }
    }
}

class StockSpanner {
    Deque<int[]> deque = null;

    public StockSpanner() {
        deque = new ArrayDeque<>();
    }

    public int next(int price) {
        int sum = 1;
        while (!deque.isEmpty() && price >= deque.peek()[0]) {
            sum = sum + deque.poll()[1];
        }
        deque.push(new int[]{price, sum});
        return sum;
    }
}