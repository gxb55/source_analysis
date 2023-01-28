package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/17 15:44
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 */
public class Solution37 {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solution37.solveSudoku(board);
        for (char[] characters : board) {
            System.out.println(Arrays.toString(characters));
        }
    }

    public void solveSudoku(char[][] board) {
        process(0, 0, board);
    }

    /**
     * @param row   行
     * @param col   列
     * @param board
     */
    private void process(int row, int col, char[][] board) {
        System.out.println(row + "_" + col);
        if (row == 9 && col == 9) {
            return;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol >= 9) {
            nextCol = 0;
            nextRow = nextRow + 1;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i < 9; i++) {
                int v = check(i, row, col, board);
                if (v != -1) {
                    board[row][col] = (char) v;
                    process(nextRow, nextCol, board);
                    board[row][col] = '.';
                }
            }
        } else {
            process(nextRow, nextCol, board);
        }
    }

    /**
     * @param row   行
     * @param col   列
     * @param board
     */
    private int check(int i, int row, int col, char[][] board) {
        Character curChar = String.valueOf(i).charAt(0);
        List<Character> list = new ArrayList<>();
        int rowIndex = row / 3;
        int colIndex = col / 3;
        if (rowIndex == 0) {
            if (colIndex == 0) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        list.add(board[j][k]);
                    }
                }
            } else if (colIndex == 1) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 3; k < 6; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    for (int k = 6; k < 9; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            }
        } else if (rowIndex == 1) {
            if (colIndex == 0) {
                for (int j = 3; j < 6; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            } else if (colIndex == 1) {
                for (int j = 3; j < 6; j++) {
                    for (int k = 3; k < 6; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            } else {
                for (int j = 3; j < 6; j++) {
                    for (int k = 6; k < 9; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            }
        } else {
            if (colIndex == 0) {
                for (int j = 6; j < 9; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            } else if (colIndex == 1) {
                for (int j = 6; j < 9; j++) {
                    for (int k = 3; k < 6; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            } else {
                for (int j = 6; j < 9; j++) {
                    for (int k = 6; k < 9; k++) {
                        if (board[j][k] != '.') {
                            list.add(board[j][k]);
                        }
                    }
                }
            }
        }

        if (list.contains(curChar)) {
            return -1;
        }
        char[] chars = board[row];
        for (Character character : chars) {
            if (character != '.' && character.equals(curChar)) {
                return -1;
            }
        }
// * @param row   行
        int row1 = row - 1;
        int col1 = col - 1;
        int col2 = col + 1;
        while (row1 >= 0 && col1 >= 0) {
            char c = board[row1][col1];
            if (c == curChar) {
                return -1;
            }
            c = board[row1][col2];
            if (c == curChar) {
                return -1;
            }
            row1--;
            col1--;
            col2++;
        }
        row1 = row - 1;
        col2 = col + 1;
        while (row1 >= 0 && col2 < 9) {
            char c = board[row1][col2];
            if (c == curChar) {
                return -1;
            }
        }
        return i;
    }
}
