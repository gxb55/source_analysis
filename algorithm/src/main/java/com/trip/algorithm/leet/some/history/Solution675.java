package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/5/23  21:27
 * @description 675
 * 675. 为高尔夫比赛砍树
 * 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：
 * <p>
 * 0 表示障碍，无法触碰
 * 1 表示地面，可以行走
 * 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
 * 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
 * <p>
 * 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * <p>
 * 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * <p>
 * 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
 * 输出：6
 * 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
 * 示例 2：
 * <p>
 * <p>
 * 输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
 * 输出：-1
 * 解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
 * 示例 3：
 * <p>
 * 输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
 * 输出：6
 * 解释：可以按与示例 1 相同的路径来砍掉所有的树。
 * (0,0) 位置的树，可以直接砍去，不用算步数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == forest.length
 * n == forest[i].length
 * 1 <= m, n <= 50
 * 0 <= forest[i][j] <= 109
 * 通过次数14,676提交次数27,841
 */
public class Solution675 {
    public static void main(String[] args) {
        Solution675 solution675 = new Solution675();
        // int[][] forest = {{1, 2, 3}, {0, 0, 4}, {7, 6, 5}};
        //int[][] forest = {{2, 3, 4}, {0, 0, 5}, {8, 7, 6}};
        int[][] forest = {{1, 2, 3}, {0, 0, 4}, {7, 6, 5}};
        // int[][] forest = {{0}, {0}, {6014}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : forest) {
            List<Integer> integerList = new ArrayList<>();
            Arrays.stream(arr).forEach(x -> {
                integerList.add(x);
            });
            list.add(integerList);
        }
        int i = solution675.cutOffTree(list);
        System.out.println(i);
    }

    private List<NodeTree1> list = new ArrayList<>();

    public int cutOffTree(List<List<Integer>> forest) {
        int[][] arr = new int[forest.size()][forest.get(0).size()];

        for (int i = 0; i < forest.size(); i++) {
            int[] temp = new int[forest.get(i).size()];
            for (int j = 0; j < forest.get(i).size(); j++) {
                temp[j] = forest.get(i).get(j);
                if (forest.get(i).get(j) > 1 && (i != j) && (i != 0)) {
                    list.add(new NodeTree1(forest.get(i).get(j), i, j));
                }
            }
            arr[i] = temp;
        }
        list = list.stream().sorted(Comparator.comparingInt(NodeTree1::getVal)).collect(Collectors.toList());
        NodeTree1 cur = new NodeTree1(0, 0, 0);
        int step = 0;
        for (int i = 0; i < list.size(); i++) {
            NodeTree1 nodeTree1 = list.get(i);
            int step1 = getStep(arr, cur, nodeTree1);
            if (step1 == 0) {
                return -1;
            }
            step = step + step1;
            cur = nodeTree1;
        }
        return step;
    }

    private int getStep(int[][] arr, NodeTree1 cur, NodeTree1 next) {
        int lenX = arr.length;
        int lenY = arr[0].length;

        boolean[][] flags = new boolean[lenX][lenY];

        Queue<NodeTree1> queue = new LinkedList();
        queue.add(cur);
        int step = -1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                NodeTree1 poll = queue.poll();

                flags[poll.getX()][poll.getY()] = true;
                if (poll.getX() == next.getX() && poll.getY() == next.getY()) {
                    flag = true;
                    break;
                }
                if ((poll.getX() + 1) < lenX && (poll.getY()) < lenY && !flags[poll.getX() + 1][poll.getY()] && arr[poll.getX() + 1][poll.getY()] != 0) {
                    queue.add(new NodeTree1(0, poll.getX() + 1, poll.getY()));
                }
                if ((poll.getX() - 1) >= 0 && (poll.getY()) >= 0 && !flags[poll.getX() - 1][poll.getY()] && arr[poll.getX() - 1][poll.getY()] != 0) {
                    queue.add(new NodeTree1(0, poll.getX() - 1, poll.getY()));
                }
                if ((poll.getX()) < lenX && (poll.getY() - 1) >= 0 && !flags[poll.getX()][poll.getY() - 1] && arr[poll.getX()][poll.getY() - 1] != 0) {
                    queue.add(new NodeTree1(0, poll.getX(), poll.getY() - 1));
                }
                if ((poll.getX()) >= 0 && (poll.getY() + 1) < lenY && !flags[poll.getX()][poll.getY() + 1] && arr[poll.getX()][poll.getY() + 1] != 0) {
                    queue.add(new NodeTree1(0, poll.getX(), poll.getY() + 1));
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            step = 0;
        }
        return step;
    }


}

class NodeTree1 {
    private int val;
    private int x;
    private int y;

    public NodeTree1(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    public int getVal() {
        return val;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "NodeTree1{" +
                "val=" + val +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}