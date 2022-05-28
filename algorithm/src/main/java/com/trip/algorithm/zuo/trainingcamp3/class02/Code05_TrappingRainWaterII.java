package com.trip.algorithm.zuo.trainingcamp3.class02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如果给你一个二维数组，每一个值表示这一块地形的高度，
 * 求整块地形能装下多少水。
 */
public class Code05_TrappingRainWaterII {
    public static void main(String[] args) {
        int[][] arr = {
                {8, 8, 8, 6, 8, 8},
                {8, 8, 8, 4, 8, 8},
                {8, 8, 8, 8, 8, 8},
                {8, 8, 1, 8, 1, 8},
                {8, 8, 7, 8, 8, 8}
        };
        int i = trapRainWater(arr);
        System.out.println(i);
    }

    /**
     * 小顶堆求出入口，求出湖泊的周围边界
     *
     * @param heightMap
     * @return
     */
    public static int trapRainWater(int[][] heightMap) {
        // 二维的湖泊的长度要大于三才能形成
        if (heightMap == null || heightMap[0].length < 3 || heightMap.length < 3) {
            return 0;
        }
        // 小顶堆 每次出来的数字都是最小的哪一个
        PriorityQueue<Node> queue = new PriorityQueue(new NodeComparator());
        int x = heightMap.length;
        int y = heightMap[0].length;
        boolean[][] arr = new boolean[x][y];
        //1.把二维数组的四周放入小顶堆，并记录放入过了
        for (int i = 0; i < x; i++) {
            // 第一列
            queue.add(new Node(heightMap[i][0], i, 0));
            arr[i][0] = true;
            // 最后一列
            queue.add(new Node(heightMap[i][y - 1], i, y - 1));
            arr[i][y - 1] = true;
        }

        for (int i = 0; i < y; i++) {
            if (!arr[0][i]) {
                //第一行
                queue.add(new Node(heightMap[0][i], 0, i));
                arr[0][i] = true;
            }
            if (!arr[x - 1][i]) {
                // 最后一行
                queue.add(new Node(heightMap[x - 1][i], x - 1, i));
                arr[x - 1][i] = true;
            }
        }
        int max = Integer.MIN_VALUE;
        int water = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            max = Math.max(max, poll.value);
            int col = poll.col;
            int row = poll.row;
            // 下一行
            if (row - 1 > -1 && !arr[row - 1][col]) {
                water = water + Math.max(max - heightMap[row - 1][col], 0);
                queue.add(new Node(heightMap[row - 1][col], row - 1, col));
                arr[row - 1][col] = true;
            }
            if (row + 1 < x && !arr[row + 1][col]) {
                water = water + Math.max(max - heightMap[row + 1][col], 0);
                queue.add(new Node(heightMap[row + 1][col], row + 1, col));
                arr[row + 1][col] = true;
            }
            // 下一列
            if (col + 1 < y && !arr[row][col + 1]) {
                water = water +  Math.max(max -heightMap[row][col + 1], 0);
                queue.add(new Node(heightMap[row][col + 1], row, col + 1));
                arr[row][col + 1] = true;
            }
            if (col - 1 > -1 && !arr[row][col - 1]) {
                water = water + Math.max(max - heightMap[row][col - 1], 0);
                queue.add(new Node(heightMap[row][col - 1], row, col - 1));
                arr[row][col - 1] = true;
            }

        }
        return water;
    }


    public static class Node {
        public int value;
        /**
         * 行
         */
        public int row;
        /**
         * 列
         */
        public int col;

        public Node(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }

    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }

    }
}
