package com.trip.algorithm.leet.some.everday;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年07月10日 11:15:00
 */
public class Solution741 {
    public static void main(String[] args) {
        Solution741 solution741 = new Solution741();
        int[][] arr =
                {{0, 1, -1},
                        {1, 0, -1},
                        {1, 1, 1}};
        int i = solution741.cherryPickup(arr);
        System.out.println(i);
    }

    public int cherryPickup(int[][] grid) {
        int res = 0;
        int length = grid.length;
        int length1 = grid[0].length;
        int[][] dp = new int[length][length1];
        Map<Node, List<Node>> map = new HashMap<>();
        dp[0][0] = grid[0][0];
        if (dp[0][0] == 1 || dp[0][0] == 0) {
            List<Node> list = new ArrayList<>();
            Node node = new Node(0, 0);
            list.add(node);
            map.put(node, list);
        }
        for (int i = 1; i < length; i++) {
            if (grid[i - 1][0] != -1 && grid[i][0] != -1) {
                dp[i][0] = grid[i - 1][0] + grid[i][0];
                Node node = new Node(i, 0);
                List<Node> list = map.getOrDefault(new Node(i - 1, 0), new ArrayList<>());
                List<Node> list1 = new ArrayList<>();
                list1.addAll(list);
                list1.add(node);
                map.put(node, list1);
            }
        }
        for (int i = 1; i < length1; i++) {
            if (grid[0][i - 1] != -1 && grid[0][i] != -1) {
                dp[0][i] = grid[0][i - 1] + grid[0][i];
                Node node = new Node(0, i);
                List<Node> list = map.getOrDefault(new Node(0, i - 1), new ArrayList<>());
                List<Node> list1 = new ArrayList<>();
                list1.addAll(list);
                list1.add(node);
                map.put(node, list1);
            }
        }


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] != -1) {
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    Node node = new Node(i, j);
                    if (left > top) {
                        List<Node> list = map.getOrDefault(new Node(i, j - 1), new ArrayList<>());
                        List<Node> list1 = new ArrayList<>();
                        list1.addAll(list);
                        list1.add(node);
                        map.put(node, list1);
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                    } else {
                        List<Node> list = map.getOrDefault(new Node(i - 1, j), new ArrayList<>());
                        List<Node> list1 = new ArrayList<>();
                        list1.addAll(list);
                        list1.add(node);
                        map.put(node, list1);
                        dp[i][j] = grid[i][j] + dp[i - 1][j];
                    }
                }
            }
        }
        List<Node> list11 = map.get(new Node(length - 1, length - 1));
        for (Node node : list11) {
            grid[node.x][node.y] = 0;
        }
        res = res + dp[length - 1][length - 1];


        int[][] dp1 = new int[length][length1];
        map.clear();
        dp1[length - 1][length - 1] = grid[length - 1][length1 - 1];
        if (dp[length - 1][length1 - 1] == 1 || dp[length - 1][length1 - 1] == 0) {
            List<Node> list1 = new ArrayList<>();
            Node node = new Node(length - 1, length1 - 1);
            list1.add(node);
            map.put(node, list1);
        }
        for (int i = length - 2; i >= 0; i--) {
            if (dp[i + 1][length1 - 1] != -1 && dp[i][length1 - 1] != -1) {
                dp[i][length1 - 1] = dp[i + 1][length1 - 1] + dp[i][length1 - 1];
                Node node = new Node(i, length1 - 1);
                List<Node> list = map.getOrDefault(new Node(i + 1, length1 - 1), new ArrayList<>());
                List<Node> list1 = new ArrayList<>();
                list1.addAll(list);
                list1.add(node);
                map.put(node, list1);
            }
        }
        for (int i = length1 - 1; i >= 1; i--) {
            if (dp[length-1][i - 1] != -1 && dp[length-1][i] != -1) {
                dp[length-1][i] = dp[length-1][i - 1] + dp[length-1][i];
                Node node = new Node(length-1, i);
                List<Node> list = map.getOrDefault(new Node(length-1, i - 1), new ArrayList<>());
                List<Node> list1 = new ArrayList<>();
                list1.addAll(list);
                list1.add(node);
                map.put(node, list1);
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = length1 - 2; j >= 0; j--) {
                if (grid[i][j] != -1) {
                    int left = dp[i][j + 1];
                    int top = dp[i + 1][j];
                    Node node = new Node(i, j);
                    if (left > top) {
                        List<Node> list = map.getOrDefault(new Node(i, j + 1), new ArrayList<>());
                        List<Node> list1 = new ArrayList<>();
                        list1.addAll(list);
                        list1.add(node);
                        map.put(node, list1);
                        dp[i][j] = grid[i][j] + dp[i][j + 1];
                    } else {
                        List<Node> list = map.getOrDefault(new Node(i + 1, j), new ArrayList<>());
                        List<Node> list1 = new ArrayList<>();
                        list1.addAll(list);
                        list1.add(node);
                        map.put(node, list1);
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    }
                }
            }
        }

        return res + dp[0][0];

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

