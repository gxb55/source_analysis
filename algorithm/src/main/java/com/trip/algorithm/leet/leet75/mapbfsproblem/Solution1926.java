package com.trip.algorithm.leet.leet75.mapbfsproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年08月31日 22:18:00
 */
public class Solution1926 {
    public static void main(String[] args) {
        Solution1926 solution1926 = new Solution1926();
      /*  char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};*/

       /* char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance = {1,0}; */

       /* char[][] maze = {{'.','+'}};
        int[] entrance = {0,0}; */

        char[][] maze = {
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '.', '.', '+'},
                {'+', '+', '+', '+', '.', '+', '.'}
        };
        int[] entrance = {0, 1};

        int i = solution1926.nearestExit(maze, entrance);
        System.out.println(i);
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int x = maze.length;
        int y = maze[0].length;
        int[][] vis = new int[x][y];
        for (int[] a : vis) {
            Arrays.fill(a, -1);
        }
        int curX = entrance[0];
        int curY = entrance[1];
        initX = curX;
        initY = curY;
        process(maze, vis, curX, curY, x, y, 0);
        for (int[] booleans : vis) {
            System.out.println(Arrays.toString(booleans));
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    int count = Integer.MAX_VALUE;
    int initX = 0;
    int initY = 0;

    private void process(char[][] maze, int[][] vis, int curX, int curY, int x, int y, int step) {
        if (curY < 0 || curY >= y || curX < 0 || curX >= x) {
            return;
        }
        if (maze[curX][curY] == '+') {
            return;
        }
        if (curX == 0 || curY == 0 || (curY == y - 1) || curX == (x - 1)) {
            if (curX != initX || curY != initY) {
                count = Math.min(step, count);
                return;
            }
        }
        if (maze[curX][curY] == '+' || (vis[curX][curY] != -1 && vis[curX][curY] < step)) {
            return;
        }
        vis[curX][curY] = step;
        process(maze, vis, curX + 1, curY, x, y, step + 1);
        process(maze, vis, curX - 1, curY, x, y, step + 1);
        process(maze, vis, curX, curY + 1, x, y, step + 1);
        process(maze, vis, curX, curY - 1, x, y, step + 1);
    }
}
