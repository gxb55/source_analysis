package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2024/8/23 16:26
 * @description TODO
 */
public class Solution295 {
    public static void main(String[] args) {
        MedianFinder1 finder = new MedianFinder1();
        finder.addNum(1);

        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());

    }
}

class MedianFinder {

    private List<Integer> list = new ArrayList<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else if (list.size() == 1) {
            if (num > list.get(0)) {
                list.add(num);
            } else {
                list.add(0, num);
            }
        } else {
            if (num <= list.get(0)) {
                list.add(0, num);
            } else if (num >= list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int t = getIndex(list, num);
                list.add(t, num);
            }
        }
        System.out.println(list);

    }

    private int getIndex(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            int mid = list.get(midIndex);
            if (mid > num) {
                right = midIndex - 1;
            } else if (mid < num) {
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return left;
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 1) {
            return list.get((size / 2));
        }
        int i = size / 2;
        return (list.get(i) + list.get(i - 1)) / 2.0;
    }
}

class MedianFinder1 {


    public MedianFinder1() {

    }

    // 从小到大
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>((y, x) -> x - y);
    // 从大到小
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x, y) -> x - y);

    public void addNum(int num) {
        if (minQueue.isEmpty() || num < minQueue.peek()) {
            minQueue.add(num);
            if (maxQueue.size() + 1 < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
        } else {
            maxQueue.add(num);
            if (maxQueue.size() > minQueue.size()) {
                minQueue.add(maxQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
        return minQueue.peek();
    }
}