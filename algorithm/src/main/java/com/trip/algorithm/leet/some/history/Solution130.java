package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月31日 11:24:00
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 * 通过次数177,590提交次数389,107
 */
public class Solution130 {
    public static void main(String[] args) {

    }
    private int x,y;
    public void solve(char[][] board) {
         x = board.length;
         y = board[0].length;
        boolean[][] vis = new boolean[x][y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'O' && i != 0 && i != (x - 1) && j != 0 && j != (y - 1)) {
                    process(board, vis, i, j);
                }
            }
        }
    }

    private Character process(char[][] board, boolean[][] vis, int i, int j) {
        if(i == 0 || i == (x - 1) || j == 0 || j == (y - 1)){
            return 'O';
        }

        return '1';
    }
}
