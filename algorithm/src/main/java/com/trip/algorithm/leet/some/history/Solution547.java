package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/4/24  21:45
 * @description 547
 * <p>
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * 通过次数205,240提交次数330,918
 * <p>
 * 深度优先搜索
 * 宽度优先搜索
 */
public class Solution547 {
    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = solution547.findCircleNum3(arr);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] vis = new boolean[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                sum++;
                dfs(isConnected, vis, i);
            }
        }
        return sum;
    }

    private void dfs(int[][] isConnected, boolean[] vis, int i) {
        int[] ints = isConnected[i];
        for (int j = 0; j < ints.length; j++) {
            if (!vis[j] && ints[j] == 1) {
                vis[i] = true;
                dfs(isConnected, vis, j);
            }
        }
    }


    public int findCircleNum1(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] vis = new boolean[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (!vis[i]) {
                sum++;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                bfs(isConnected, vis, queue);
            }
        }
        return sum;
    }

    private void bfs(int[][] isConnected, boolean[] vis, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            vis[poll] = true;
            int[] ints = isConnected[poll];
            for (int i = 0; i < ints.length; i++) {
                if (!vis[i] && ints[i] == 1) {
                    queue.add(i);
                }
            }
        }

    }

    public int findCircleNum3(int[][] isConnected) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            uf.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    uf.merge(i, j);
                }
            }
        }
        return uf.getNumOfSets();
    }

}

class UnionFind {
    // 记录父节点 key当前结点，value 父节点
    private Map<Integer, Integer> father;
    // 记录集合的数量
    private int numOfSets = 0;

    public UnionFind() {
        father = new HashMap<Integer, Integer>();
        numOfSets = 0;
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            numOfSets++;
            father.put(x, null);
        }
    }

    public void merge(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        numOfSets--;
        father.put(xParent, yParent);
    }

    public int find(int x) {
        int root = x;
        while (father.get(root) != null) {
            root = father.get(root);
        }

        while (x != root) {
            Integer integer = father.get(x);
            father.put(x, root);
            x = integer;
        }
        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getNumOfSets() {
        return numOfSets;
    }

}