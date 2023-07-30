package com.trip.algorithm.leet.some.leet2307;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年07月22日 09:48:00
 */
public class Solution1499 {
    public static void main(String[] args) {
        // int[][] points = {{1,3},{2,0},{5,10},{6,-10}};int k = 1;
        //    int[][] points  = {{0,0},{3,0},{9,2}};int k = 3;
        int[][] points = {
                {-19, -12}, {-13, -18}, {-12, 18},
                {-11, -8}, {-8, 2}, {-7, 12},
                {-5, 16}, {-3, 9}, {1, -7}, {5, -4}, {6, -20},
                {10, 4}, {16, 4}, {19, -9}, {20, 19}};
        int k = 6;


        int val = findMaxValueOfEquation(points, k);
        System.out.println(val);

        int val1 = findMaxValueOfEquation1(points, k);
        System.out.println(val1);
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        // 按照最大值排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));
        //yi + yj + |xi - xj| 1 <= i < j <= points.length points[i] = [xi, yi]
        int res = Integer.MIN_VALUE;
        for (int[] t : points) {
            // 不符合x条件的都排除调，则第一个就是符合条件的最大值，queue里面可能有多的值，但是不是最大的，这个条件保障第一个就是符合条件的，
            // 自然的排序条件保障了第一个就是最大的
            while (!queue.isEmpty() && (t[0] - queue.peek()[1]) > k) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                res = Math.max(queue.peek()[0] + t[0] + t[1], res);
            }
            /**
             * j>i
             * yi + yj + |xi - xj|
             * // 数组是按照x排好序的所以去掉绝对值之后就是
             * yi + yj + xj - xi
             * yj + xj + yi-xi
             * yj + xj 就是当前数组的和，yi-xi 越大内容越大 按照yi-xi来做大顶堆
             *
             */
            queue.add(new int[]{t[1] - t[0], t[0]});
        }
        return res;
    }

    public static int findMaxValueOfEquation1(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!heap.isEmpty() && x - heap.peek()[1] > k) {
                heap.poll();
            }
            if (!heap.isEmpty()) {
                res = Math.max(res, x + y - heap.peek()[0]);
            }
            heap.offer(new int[]{x - y, x});
        }
        return res;
    }


}
