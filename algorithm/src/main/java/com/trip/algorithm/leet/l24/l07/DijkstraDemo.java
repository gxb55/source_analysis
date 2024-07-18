package com.trip.algorithm.leet.l24.l07;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/7/18 16:16
 */
public class DijkstraDemo {

    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;    // 无法到达时距离设为 Integer.MAX_VALUE
        int[][] weight = {
            {0, 1, 12, MAX, MAX, MAX},
            {MAX, 0, 9, 3, MAX, MAX},
            {MAX, MAX, 0, MAX, 5, MAX},
            {MAX, MAX, 4, 0, 13, 15},
            {MAX, MAX, MAX, MAX, 0, 4},
            {MAX, MAX, MAX, MAX, MAX, 0}
        };
        int start = 0;  // 选择出发点
        System.out.println(Arrays.toString(solution(weight, start)));
        System.out.println(Arrays.toString(solution1(weight, start)));
    }

    private static int[] solution(int[][] weight, int start) {
        int res[] = new int[weight.length];
        boolean[] vis = new boolean[weight.length];

        for (int i = 0; i < weight.length; i++) {
            res[i] = weight[start][i];
        }
        vis[start] = true;
        for (int i = 1; i < weight.length; i++) {
            int p = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < res.length; j++) {
                if (!vis[j] && res[j] < min) {
                    min = res[j];
                    p = j;
                }
            }
            if (p == -1) {
                continue;
            }
            vis[p] = true;
            for (int j = 0; j < res.length; j++) {
                // p 点不能到达 j
                if (vis[j] || weight[p][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (res[j] > (res[p] + weight[p][j])) {
                    //更新最短路径
                    res[j] = res[p] + weight[p][j];
                }

            }
        }
        return res;
    }

    private static int[] solution1(int[][] weight, int start) {
        boolean[] visit = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] res = new int[weight.length];     // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for (int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for (int j = 0; j < weight.length; j++) {
                if (j != start && !visit[j] && res[j] < min) {
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;

            for (int j = 0; j < weight.length; j++) {
                if (j == p || weight[p][j] == Integer.MAX_VALUE) {  // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]) {
                    res[j] = res[p] + weight[p][j];  //更新最短路径
                }
            }
        }

        return res;
    }
}
