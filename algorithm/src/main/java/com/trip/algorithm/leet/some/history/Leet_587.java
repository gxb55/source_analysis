package com.trip.algorithm.leet.some.history;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年04月23日 13:44:00
 * <p>
 * 587. 安装栅栏
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 * <p>
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 * <p>
 * <p>
 * 注意:
 * <p>
 * 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
 * 输入的整数在 0 到 100 之间。
 * 花园至少有一棵树。
 * 所有树的坐标都是不同的。
 * 输入的点没有顺序。输出顺序也没有要求。
 * 通过次数7,471提交次数13,128
 */
public class Leet_587 {
    public int[][] outerTrees(int[][] trees) {
        int x = trees[0][0];
        int y = trees[0][1];
        int len = trees.length;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < len; i++) {
            int[] tree = trees[i];
            if (x != tree[0]) {
                flag1 = true;
            }
            if (y != tree[1]) {
                flag2 = true;
            }
            if (flag1 && flag2) {
                break;
            }
        }
        if (!flag1 || !flag2) {
            return trees;
        }
        Tree left = new Tree();
        Tree right = new Tree();
        Tree top = new Tree();
        Tree bottom = new Tree();

        for (int i = 0; i < len; i++) {
            int[] tree = trees[i];
            x = tree[0];
            y = tree[1];
            if (left.x == null) {
                left.x = x;
                left.y = y;
            } else if (x < left.x) {
                left.x = x;
                left.y = y;
            }

            if (right.x == null) {
                right.x = x;
                right.y = y;
            } else if (x > left.x) {
                right.x = x;
                right.y = y;
            }

            if (top.y == null) {
                top.y = y;
                top.x = x;
            } else if (y > top.y) {
                top.y = y;
                top.x = x;
            }

            if (bottom.y == null) {
                bottom.y = y;
                bottom.x = x;
            } else if (y < bottom.y) {
                bottom.y = y;
                bottom.x = x;
            }
        }
        Set<Tree> set = new HashSet<>();
        set.add(left);
        set.add(right);
        set.add(top);
        set.add(bottom);
        for (int i = 0; i < len; i++) {
            int[] tree = trees[i];
            if (checkTree(tree, left, right, top, bottom)) {
                set.add(new Tree(tree[0], tree[1]));
            }
        }
        int[][] result = new int[set.size()][2];
        int index = 0;
        for (Tree tree : set) {
            result[index] = new int[]{tree.x, tree.y};
            index++;
        }
        return result;
    }

    private boolean checkTree(int[] tree, Tree left, Tree right, Tree top, Tree bottom) {
        int x = tree[0];
        int y = tree[1];
        double t1 = (top.y - left.y) / (top.x - left.x);
        double t2 = (left.y - bottom.y) / (bottom.x - left.x);
        double t3 = (top.y - right.y) / (right.x - top.x);
        double t4 = (right.y - bottom.y) / (right.x - bottom.x);
        int i = x - left.x;
        int j = right.x - x;

        double curY1 = left.y + (i * t1);
        double curY2 = left.y - (i * t2);

        double curY3 = right.y - (j * t3);
        double curY4 = right.y + (j * t4);
        if (y >= curY1 || y <= curY2 || y <= curY3 || y >= curY4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leet_587 leet_587 = new Leet_587();
        // int[][] result = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        int[][] result = {{1, 2}, {2, 2}, {4, 2}};
        int[][] ints = leet_587.outerTrees(result);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] outerTrees1(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[leftMost][0]) {
                leftMost = i;
            }
        }

        List<int[]> res = new ArrayList<int[]>();
        boolean[] visit = new boolean[n];
        int p = leftMost;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                /* 如果 r 在 pq 的右侧，则 q = r */
                if (cross(trees[p], trees[q], trees[r]) < 0) {
                    q = r;
                }
            }
            /* 是否存在点 i, 使得 p 、q 、i 在同一条直线上 */
            for (int i = 0; i < n; i++) {
                if (visit[i] || i == p || i == q) {
                    continue;
                }
                if (cross(trees[p], trees[q], trees[i]) == 0) {
                    res.add(trees[i]);
                    visit[i] = true;
                }
            }
            if (!visit[q]) {
                res.add(trees[q]);
                visit[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return res.toArray(new int[][]{});
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
//竞赛
}

class Tree {
    public Integer x;
    public Integer y;

    public Tree() {
    }

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(x, tree.x) && Objects.equals(y, tree.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}