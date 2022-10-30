package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年06月03日 20:47:00
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * <p>
 * 通过次数321,992提交次数695,064
 */
public class Solution79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
       /* char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";*/


        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean exist = solution79.exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[] vis = new boolean[word.length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                for (int k = 0; k < vis.length; k++) {
                    if (!vis[k] && c == chars[k]) {
                        vis[k] = true;
                    }
                }
            }
        }
        for (boolean flag : vis) {
            if (!flag) {
                return false;
            }
        }
        int x = board.length;
        int y = board[0].length;
        boolean[][] vist = new boolean[x][y];
        int index = 0;
        int i = -1;
        int j = -1;
        return bfs(board, vist, chars, index, i, j);
    }

    private boolean bfs(char[][] board, boolean[][] vist, char[] chars, int index, int curI, int curJ) {
        if (index == chars.length) {
            return true;
        }
        if (curI == -1 && curJ == -1) {
            boolean flag = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (!vist[i][j] && board[i][j] == chars[index]) {
                        vist[i][j] = true;
                        if (bfs(board, vist, chars, index + 1, i, j)) {
                            return true;
                        }
                        vist[i][j] = false;
                    }
                }
            }
            return flag;
        } else {
            boolean flag = false;
            if ((curI - 1) >= 0 && !vist[curI - 1][curJ] && board[curI - 1][curJ] == chars[index]) {
                vist[curI - 1][curJ] = true;
                flag = flag || bfs(board, vist, chars, index + 1, curI - 1, curJ);
                vist[curI - 1][curJ] = false;
            }
            if ((curI + 1) < board.length && !vist[curI + 1][curJ] && board[curI + 1][curJ] == chars[index]) {
                vist[curI + 1][curJ] = true;
                flag = flag || bfs(board, vist, chars, index + 1, curI + 1, curJ);
                vist[curI + 1][curJ] = false;
            }
            if ((curJ - 1) >= 0 && !vist[curI][curJ - 1] && board[curI][curJ - 1] == chars[index]) {
                vist[curI][curJ - 1] = true;
                flag = flag || bfs(board, vist, chars, index + 1, curI, curJ - 1);
                vist[curI][curJ - 1] = false;
            }
            if ((curJ + 1) < board[0].length && !vist[curI][curJ + 1] && board[curI][curJ + 1] == chars[index]) {
                vist[curI][curJ + 1] = true;
                flag = flag || bfs(board, vist, chars, index + 1, curI, curJ + 1);
                vist[curI][curJ + 1] = false;
            }
            return flag;
        }
    }
}
