package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author xbguo
 * @date 2022/6/9  14:47
 * @description 497
 * 497. 非重叠矩形中的随机点
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * <p>
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 * <p>
 * 请注意 ，整数点是具有整数坐标的点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["Solution", "pick", "pick", "pick", "pick", "pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
 * 输出:
 * [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
 * <p>
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -109 <= ai < xi <= 109
 * -109 <= bi < yi <= 109
 * xi - ai <= 2000
 * yi - bi <= 2000
 * 所有的矩形不重叠。
 * pick 最多被调用 104 次。
 * 通过次数9,693提交次数23,201
 */
public class Solution497 {
    public static void main(String[] args) {
       // int[][] arr = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        int[][] arr = {{82918473,-57180867,82918476,-57180863},{83793579,18088559,83793580,18088560},{66574245,26243152,66574246,26243153},{72983930,11921716,72983934,11921720}};
        Solution497 solution497 = new Solution497(arr);
        int[] pick = solution497.pick();
        System.out.println(Arrays.toString(pick));
    }

    private List<Node497> list1 = new ArrayList<>();
    Random random = new Random();
    int[][] rects = null;

    public Solution497(int[][] rects) {
        this.rects = rects;
        /*for (int[] arr : rects) {
            int i0 = arr[0];
            int i1 = arr[1];
            int i2 = arr[2];
            int i3 = arr[3];
            int x = i2 - i0;
            int y = i3 - i1;
            for (int i = i0; i <= i0 + x; i++) {
                for (int j = i1; j <= i1 + y; j++) {
                    Node497 node497 = new Node497(i, j);
                    if (list1.contains(node497)) {
                        list1.remove(node497);
                    } else {
                        list1.add(node497);
                    }
                }
            }
        }*/
    }

    public int[] pick() {
       /* int i = random.nextInt(list1.size());
        Node497 node497 = list1.get(i);
        return new int[]{node497.x, node497.y};*/
        int i = random.nextInt(rects.length);
        int[] rect = rects[i];
        int i0 = rect[0];
        int i1 = rect[1];
        int i2 = rect[2];
        int i3 = rect[3];
        long x = i2 - i0;
        long y = i3 - i1;
        long l = (long) (Math.random() * x);
        long t = (long) (Math.random() * y);
        return new int[]{(int) (i0 + l), (int) (i1 + t)};
    }
}

class Node497 {
    public int x;
    public int y;

    public Node497(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node497 node497 = (Node497) o;
        return x == node497.x && y == node497.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Node497{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
