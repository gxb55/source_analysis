package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xbguo
 * @createTime 2022年06月05日 16:18:00
 * 478. 在圆内随机生成点
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < radius <= 108
 * -107 <= x_center, y_center <= 107
 * randPoint 最多被调用 3 * 104 次
 * 通过次数18,877提交次数40,649
 */
public class Solution478 {
    public static void main(String[] args) {


        //Solution solution = new Solution(1.0, 0.0, 0.0);
        Solution solution = new Solution(10.0, 5.0, -7.5);
        System.out.println(Arrays.toString(solution.randPoint()));
    }
}

class Solution {
    double r;
    double curX;
    double curY;

    Random random = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.curX = x_center;
        this.curY = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{curX + x, curY + y};
            }
        }

    }
}