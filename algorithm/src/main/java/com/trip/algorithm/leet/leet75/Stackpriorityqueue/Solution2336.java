package com.trip.algorithm.leet.leet75.Stackpriorityqueue;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年08月05日 17:44:00
 */
public class Solution2336 {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet =new SmallestInfiniteSet();
        /**
         * ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
         * [[], [2], [], [], [], [1], [], [], []]
         */
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}

class SmallestInfiniteSet {
    PriorityQueue<Integer> queueCur = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
    int cur = 1;

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (!queueCur.isEmpty()) {
            return queueCur.poll();
        }
        int t = cur;
        cur++;
        return t;
    }

    public void addBack(int num) {
        if (num < cur && !queueCur.contains(num)) {
            queueCur.add(num);
        }
    }
}