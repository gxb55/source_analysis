package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/26  17:14
 * @description 130. 被围绕的区域
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution130 {
    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
       // char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //char[][] board = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        solution130.solve(board);
    }

    public void solve(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] vis = new boolean[x][y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    vis = new boolean[x][y];
                    List<int[]> list = new ArrayList<>();
                    boolean flag = process(board, i, j, vis, list);
                    if (flag) {
                        for (int[] arr : list) {
                            int i1 = arr[0];
                            int i2 = arr[1];
                            board[i1][i2] = 'X';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                System.out.print(c+"  ");
            }
            System.out.println();
        }


    }

    private boolean process(char[][] board, int i, int j, boolean[][] vis, List<int[]> list) {
        if (i < 0 || i >= vis.length || j < 0 || j >= vis[0].length) {
            return false;
        }
        if (vis[i][j]) {
            return true;
        }
        list.add(new int[]{i, j });
        vis[i][j] = true;
        if (board[i][j] == 'X') {
            return true;
        } else {
            boolean flag = true;
            flag = flag && process(board, i - 1, j, vis, list);
            flag = flag && process(board, i + 1, j, vis, list);
            flag = flag && process(board, i , j + 1, vis, list);
            flag = flag && process(board, i , j - 1, vis, list);
            return flag;
        }
    }
}
