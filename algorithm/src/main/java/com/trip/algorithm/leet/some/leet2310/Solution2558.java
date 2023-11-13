package com.trip.algorithm.leet.some.leet2310;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年10月29日 09:58:00
 */
public class Solution2558 {
    public static void main(String[] args) {
       /* int[] gifts = {25, 64, 9, 4, 100};
        int k = 4; */

        int[] gifts = {1,1,1,1};
        int k = 4;
        long l = pickGifts(gifts, k);
        System.out.println(l);
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int gift : gifts) {
            queue.add(gift);
        }
        while (k > 0) {
            k--;
            Integer poll = queue.poll();
            double pow = Math.pow(poll, 0.5);
            queue.add((int) Math.floor(pow));
        }
        long sum = queue.stream().mapToLong(x -> x).sum();
        return sum;
    }
}
