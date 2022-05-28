package com.trip.algorithm.leet.some;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年04月16日 20:15:00
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * 通过次数449,355提交次数782,068
 */
public class Leet_200 {
    public static void main(String[] args) {
        Leet_200 leet_200 = new Leet_200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int i = leet_200.numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        List<Grap> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                Grap grap = new Grap(i, j);
                if (val == '1') {
                    grid[grap.x][grap.y] = 2;
                    findGrab(i, j, list, grid, grap);
                    num++;
                }
            }
        }
        return num;
    }

    private void findGrab(int x, int y, List<Grap> list, char[][] grid, Grap grap) {
        Queue<Grap> temp = new LinkedList<>();
        temp.add(grap);
        list.add(grap);
        int len = grid.length;
        int len1 = grid[0].length;
        while (!temp.isEmpty()) {
            Grap poll = temp.poll();
            if (poll.x + 1 < len && grid[poll.x + 1][poll.y] == '1') {
                grap = new Grap(poll.x + 1, poll.y);
                grid[poll.x + 1][poll.y] = 2;
                temp.add(grap);
                list.add(grap);
            }
            if (poll.x - 1 >= 0 && grid[poll.x - 1][poll.y] == '1') {
                grap = new Grap(poll.x - 1, poll.y);
                grid[poll.x - 1][poll.y] = 2;
                temp.add(grap);
                list.add(grap);
            }
            if (poll.y + 1 < len1 && grid[poll.x][poll.y + 1] == '1') {
                grap = new Grap(poll.x, poll.y + 1);
                grid[poll.x][poll.y + 1] = 2;
                temp.add(grap);
                list.add(grap);
            }
            if (poll.y - 1 >= 0 && grid[poll.x][poll.y - 1] == '1') {
                grap = new Grap(poll.x, poll.y - 1);
                grid[poll.x][poll.y - 1] = 2;
                temp.add(grap);
                list.add(grap);
            }
        }
    }
}

class Grap {
    public int x;
    public int y;

    public Grap(int x, int y) {
        this.x = x;
        this.y = y;
    }
}