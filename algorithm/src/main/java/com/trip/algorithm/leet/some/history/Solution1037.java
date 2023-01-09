package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/6/8  10:38
 * @description 1037
 * 1037. 有效的回旋镖
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * <p>
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 *
 * 正值高考之际，有必要复习一下三点共线向量公式。
 * 当三个点满足:
 * (x_2 - x_1) \times (y_3 - y_1) = (x_3 - x_1) \times (y_2 - y_1)(x
 * 2
 * ​
 *  −x
 * 1
 * ​
 *  )×(y
 * 3
 * ​
 *  −y
 * 1
 * ​
 *  )=(x
 * 3
 * ​
 *  −x
 * 1
 * ​
 *  )×(y
 * 2
 * ​
 *  −y
 * 1
 * ​
 *  )
 * 时共线，否则为回旋镖。
 *

 */
public class Solution1037 {
    public static void main(String[] args) {
       // int[][] arr = {{1, 1}, {2, 3}, {3, 2}};
        int[][] arr = {{0,0},{2,1},{2,1}};
        Solution1037 solution1037 = new Solution1037();
        boolean boomerang = solution1037.isBoomerang(arr);
        System.out.println(boomerang);
    }

    public boolean isBoomerang(int[][] points) {
        int[] point0 = points[0];
        int[] point1 = points[1];
        int[] point2 = points[2];
        if(point0[0]==point1[0]&& point1[1] == point0[1]){
            return false;
        }
        if(point0[0]==point2[0]&& point2[1] == point0[1]){
            return false;
        }
        if(point1[0]==point2[0]&& point2[1] == point1[1]){
            return false;
        }
        if (point0[0] == point1[0] && point1[0] == point2[0]) {
            return false;
        }
        if (point0[1] == point1[1] && point1[1] == point2[1]) {
            return false;
        }
        if (Math.abs(point0[0] - point1[0]) == Math.abs(point0[1] - point1[1]) && Math.abs(point2[0] - point1[0]) == Math.abs(point2[1] - point1[1])) {
            return false;
        }
        return true;
    }


}
