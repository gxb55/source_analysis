package com.trip.algorithm.leet.leet75.queueproblem;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2023年08月12日 12:33:00
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 */
public class Solution933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

    }

}

class RecentCounter {
    LinkedList<Integer> list;

    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);
        while (list.peekFirst() < t - 3000) {
            list.pollFirst();
        }
        return list.size();
    }
}