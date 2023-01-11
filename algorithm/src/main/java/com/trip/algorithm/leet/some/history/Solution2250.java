package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/4/25  21:44
 * @description 2250
 * 2250. 统计包含每个点的矩形数目 显示英文描述
 * 通过的用户数951
 * 尝试过的用户数2903
 * 用户总通过次数1002
 * 用户总提交次数6670
 * 题目难度Medium
 * 给你一个二维整数数组 rectangles ，其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi 。给你一个二维整数数组 points ，其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点。
 * <p>
 * 第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi) 。
 * <p>
 * 请你返回一个整数数组 count ，长度为 points.length，其中 count[j]是 包含 第 j 个点的矩形数目。
 * <p>
 * 如果 0 <= xj <= li 且 0 <= yj <= hi ，那么我们说第 i 个矩形包含第 j 个点。如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
 * 输出：[2,1]
 * 解释：
 * 第一个矩形不包含任何点。
 * 第二个矩形只包含一个点 (2, 1) 。
 * 第三个矩形包含点 (2, 1) 和 (1, 4) 。
 * 包含点 (2, 1) 的矩形数目为 2 。
 * 包含点 (1, 4) 的矩形数目为 1 。
 * 所以，我们返回 [2, 1] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：rectangles = [[1,1],[2,2],[3,3]], points = [[1,3],[1,1]]
 * 输出：[1,3]
 * 解释：
 * 第一个矩形只包含点 (1, 1) 。
 * 第二个矩形只包含点 (1, 1) 。
 * 第三个矩形包含点 (1, 3) 和 (1, 1) 。
 * 包含点 (1, 3) 的矩形数目为 1 。
 * 包含点 (1, 1) 的矩形数目为 3 。
 * 所以，我们返回 [1, 3] 。
 */
public class Solution2250 {
    public static void main(String[] args) {
        Solution2250 solution2250 = new Solution2250();
       /* int[][] rectangles = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points = {{1, 3}, {1, 1}}; */
        /*int[][] rectangles = {{1, 2}, {2, 3}, {2, 5}};
        int[][] points = {{2, 1}, {1, 4}};*/
        int[][] rectangles = {{7,1},{2,6},{1,4},{5,2},{10,3},{2,4},{5,9}};
        int[][] points = {{10,3},{8,10},{2,3},{5,4},{8,5},{7,10},{6,6},{3,6}};
        int[] ints = solution2250.countRectangles(rectangles, points);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {

        int length = points.length;
        int[] res = new int[length];
        for (int i = 0; i < points.length; i++) {
            res[i] = getNum(rectangles, points[i]);
        }
        return res;
    }

    private int getNum(int[][] rectangles, int[] point) {
        int x = point[0];
        int y = point[1];
        int sum = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            if (x <= x1 && y <= y1) {
                sum++;
            }
        }
        return sum;
    }
}