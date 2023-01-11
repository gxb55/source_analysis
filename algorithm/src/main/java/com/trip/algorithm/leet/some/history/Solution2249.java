package com.trip.algorithm.leet.some.history;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/25  21:09
 * @description 2249
 * 2249. 统计圆内格点数目 显示英文描述
 * 通过的用户数2961
 * 尝试过的用户数3703
 * 用户总通过次数3069
 * 用户总提交次数6884
 * 题目难度Medium
 * 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 * <p>
 * 注意：
 * <p>
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：circles = [[2,2,1]]
 * 输出：5
 * 解释：
 * 给定的圆如上图所示。
 * 出现在圆内的格点为 (1, 2)、(2, 1)、(2, 2)、(2, 3) 和 (3, 2)，在图中用绿色标识。
 * 像 (1, 1) 和 (1, 3) 这样用红色标识的点，并未出现在圆内。
 * 因此，出现在至少一个圆内的格点数目是 5 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：circles = [[2,2,2],[3,4,1]]
 * 输出：16
 * 解释：
 * 给定的圆如上图所示。
 * 共有 16 个格点出现在至少一个圆内。
 * 其中部分点的坐标是 (0, 2)、(2, 0)、(2, 4)、(3, 2) 和 (4, 4) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= circles.length <= 200
 * circles[i].length == 3
 * 1 <= xi, yi <= 100
 * 1 <= ri <= min(xi, yi)
 */
public class Solution2249 {
    public static void main(String[] args) {
        Solution2249 solution2249 = new Solution2249();
        int[][] arr = {{8, 9, 6}, {8, 9, 6}, {4, 1, 1}, {8, 5, 1}, {7, 1, 1}, {6, 7, 5}, {7, 1, 1}, {7, 1, 1}, {5, 5, 3}};
        int i = solution2249.countLatticePoints(arr);
        System.out.println(i);
    }

    public int countLatticePoints(int[][] circles) {
        Set<int[]> set = new HashSet<>();
        Set<NodeTree> set2 = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            NodeTree a = new NodeTree(circle[0], circle[1], circle[2]);
            if (set2.add(a)) {
                buildSet(circle, set);
            }
        }
        Set<NodeTree> set1 = new HashSet<>();
        int sum = 0;
        for (int[] arr : set) {
            if (set1.add(new NodeTree(arr[0], arr[1]))) {
                sum++;
            }
        }
        return sum;
    }

    private void buildSet(int[] circle, Set<int[]> set) {
        int x = circle[0];
        int y = circle[1];
        int r = circle[2];
        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                if (i == x && Math.abs(j - y) <= r) {
                    int[] arr = {i, j};
                    set.add(arr);
                } else if (j == y && Math.abs(i - x) <= r) {
                    int[] arr = {i, j};
                    set.add(arr);
                } else {
                    int a = Math.abs(i - x);
                    int b = Math.abs(j - y);
                    if ((a * a + b * b) <= (r * r)) {
                        int[] arr = {i, j};
                        set.add(arr);
                    }
                }
            }
        }
    }
}

class NodeTree {
    public int x;
    public int y;
    public int z;

    public NodeTree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public NodeTree(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeTree node1 = (NodeTree) o;
        return x == node1.x && y == node1.y && z == node1.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
