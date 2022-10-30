package com.trip.algorithm.leet.some.everday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年07月02日 19:27:00
 * <p>
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * <p>
 * <p>
 * 通过次数72,528提交次数91,907
 */
public class Solution794 {
    public static void main(String[] args) {
        Solution794 solution794 = new Solution794();
       // int[][] graph = {{1, 2}, {3}, {3}, {}};
        int[][] graph =  {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> list = solution794.allPathsSourceTarget(graph);
        for (List<Integer> temp : list) {
            System.out.println(temp);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int index = 0;
        int result = graph.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        process(graph, list, tempList, index, result);
        return list;
    }

    private void process(int[][] graph, List<List<Integer>> list, List<Integer> tempList, int index, int result) {
        if (index == result) {
            List<Integer> integers = new ArrayList<>();
            integers.addAll(tempList);
            list.add(integers);
            return;
        }
        int[] ints = graph[index];
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            tempList.add(anInt);
            process(graph, list, tempList, anInt, result);
            tempList.remove(Integer.valueOf(anInt));
        }
    }
}
