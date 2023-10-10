package com.trip.algorithm.leet.some.leet2310;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/10/8 10:26
 * ["StockPrice","update","update","current","maximum","update","maximum","update","minimum"]
 * [[],[1,10],[2,5],[],[],[1,3],[],[4,2],[]]
 * 输出
 * [null,null,null,1,5,null,3,null,10]
 */
public class Solution2034 {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);

        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }

}

class StockPrice {

    private Map<Integer, int[]> map;
    private PriorityQueue<int[]> maxPriceQueue;
    private PriorityQueue<int[]> minPriceQueue;
    private int max = 0;

    public StockPrice() {
        map = new HashMap<>();
        maxPriceQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        minPriceQueue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    }

    public void update(int timestamp, int price) {
        max = Math.max(timestamp, max);
        int[] ints = {timestamp, price};

        maxPriceQueue.add(ints);
        minPriceQueue.add(ints);
        map.put(timestamp, ints);
    }

    public int current() {
        return map.get(max)[1];
    }

    public int maximum() {
        while (true) {
            int[] peek = maxPriceQueue.peek();
            if (peek[1] == map.get(peek[0])[1]) {
                return peek[1];
            } else {
                maxPriceQueue.poll();
            }
        }
    }

    public int minimum() {
        while (true) {
            int[] peek = minPriceQueue.peek();
            if (peek[1] == map.get(peek[0])[1]) {
                return peek[1];
            } else {
                minPriceQueue.poll();
            }
        }
    }
}