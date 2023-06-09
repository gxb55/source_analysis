package com.trip.algorithm.leet.graph;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/6/9 14:48
 * 迪杰斯特拉算法解决的问题是：
 * <p>
 * 在一个有向图中，求图中一个节点到其他所有节点的最短距离
 */
public class DijkstraTest {
    // 无法到达时距离设为 Integer.MAX_VALUE
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] weight = {
                {0, 1, 12, MAX, MAX, MAX},
                {MAX, 0, 9, 3, MAX, MAX},
                {MAX, MAX, 0, MAX, 5, MAX},
                {MAX, MAX, 4, 0, 13, 15},
                {MAX, MAX, MAX, MAX, 0, 4},
                {MAX, MAX, MAX, MAX, MAX, 0}
        };
        // 选择出发点
        int start = 0;
        // [0, 1, 8, 4, 13, 17]
        System.out.println(Arrays.toString(solution1(weight, start)));
    }
    private static int[] solution1(int[][] weight, int start) {
        boolean[] visit = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] res = new int[weight.length];     // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for(int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for(int j = 0; j < weight.length; j++){
                if(j != start && !visit[j] && res[j] < min){
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;

            for (int j = 0; j < weight.length; j++){
                if (j == p || weight[p][j] == Integer.MAX_VALUE) {  // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]){
                    res[j] = res[p] + weight[p][j];  //更新最短路径
                }
            }
        }

        return res;
    }
    private static int[] solution(int[][] weight, int start) {
        boolean[] vis = new boolean[weight.length];
        vis[start] = true;
        int[] dest = new int[weight.length];
        for (int i = 0; i < weight[start].length; i++) {
                dest[i] = weight[start][i];
        }
        for (int i = 1; i < weight.length; i++) {
            int p = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < weight.length; j++) {
                if ( !vis[j] && dest[j] < min) {
                    min = dest[j];
                    p = j;
                }
            }
            vis[p] = true;

            for (int j = 0; j < weight.length; j++) {
                if (weight[p][j] == MAX || p == j) {
                    continue;
                }
                if (dest[j] > weight[p][j] + dest[p]) {
                    dest[j] = weight[p][j] + dest[p];
                }
            }
        }
        return dest;
    }
}
