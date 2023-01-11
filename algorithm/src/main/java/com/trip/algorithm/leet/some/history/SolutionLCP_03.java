package com.trip.algorithm.leet.some.history;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/5/10  17:32
 * @description LCP 03. 机器人大冒险
 * LCP 03. 机器人大冒险
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 * <p>
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * <p>
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 * 示例 2：
 * <p>
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 * 示例 3：
 * <p>
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 * 通过次数13,002提交次数57,311
 */
public class SolutionLCP_03 {
    public static void main(String[] args) {
        SolutionLCP_03 solutionLCP_03 = new SolutionLCP_03();
        int[][] arr = {};
        // command = "URR", obstacles = [], x = 3, y = 2
        boolean robot = solutionLCP_03.robot("URR", arr, 3, 2);
        System.out.println(robot);
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char[] chars = command.toCharArray();
        Set<Obstacle> set = new HashSet<>();
        for (int[] arr : obstacles) {
            set.add(new Obstacle(arr[0], arr[1]));
        }
        int curX = 0;
        int curY = 0;
        /**
         *  * U: 向y轴正方向移动一格
         *  * R: 向x轴正方向移动一格。
         */
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == 'U') {
                    curY++;
                } else if (aChar == 'R') {
                    curX++;
                }
                if (curX == x && curY == y) {
                    return true;
                }
                if (curX > x || curY > y) {
                    return false;
                }
                boolean contains = set.contains(new Obstacle(curX, curY));
                if (contains) {
                    return false;
                }
            }
        }


    }
}

class Obstacle {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return x == obstacle.x && y == obstacle.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
