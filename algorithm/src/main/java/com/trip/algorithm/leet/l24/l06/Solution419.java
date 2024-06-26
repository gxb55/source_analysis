package com.trip.algorithm.leet.l24.l06;

import java.util.ArrayList;
import java.util.List;

public class Solution419 {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X'}};
        int i = countBattleships(board);
        System.out.println(i);
    }

    public static int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < col && board[i][k] == 'X'; ++k) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < row && board[k][j] == 'X'; ++k) {
                        board[k][j] = '.';
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
