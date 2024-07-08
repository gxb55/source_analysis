package com.trip.algorithm.leet.l24.l07;

public class Solution1958 {
    public static void main(String[] args) {
       /* char[][] arr = {
                {'W', 'W', '.', 'B', '.', 'B', 'B', '.'},
                {'W', 'B', '.', '.', 'W', 'B', '.', '.'},
                {'B', 'B', 'B', 'B', 'W', 'W', 'B', '.'},
                {'W', 'B', '.', '.', 'B', 'B', 'B', '.'},
                {'W', 'W', 'B', '.', 'W', '.', 'B', 'B'},
                {'B', '.', 'B', 'W', '.', 'B', '.', '.'},
                {'.', 'B', 'B', 'W', 'B', 'B', '.', '.'},
                {'B', 'B', 'W', '.', 'B', 'B', '.', '.'}
        };
        int rMove = 7;
        int cMove = 4;
        Character color = 'B';*/
/*
        char[][] arr =
                {
                        {'B', 'B', '.', '.', 'B', 'W', 'W', '.'},
                        {'.', 'W', 'W', '.', 'B', 'W', 'B', 'B'},
                        {'.', 'W', 'B', 'B', 'W', 'W', 'W', '.'},
                        {'B', '.', '.', 'B', 'W', 'W', 'W', '.'},
                        {'W', 'W', 'W', 'B', 'W', '.', 'B', 'W'},
                        {'.', '.', '.', 'W', '.', 'W', '.', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B'},
                        {'W', '.', 'W', 'W', '.', 'B', '.', 'W'}
                };
        int rMove = 2;
        int cMove = 5;

// (rMove, cMove)
        Character color = 'W'; */
       /* char[][] arr =
                {
                        {'B','W','.','.','.','W','.','B'},
                        {'W','B','B','W','B','W','W','B'},
                        {'.','B','W','.','W','.','.','W'},
                        {'.','W','B','.','W','.','.','.'},
                        {'W','.','.','.','B','W','W','.'},
                        {'.','B','B','.','W','W','.','W'},
                        {'.','.','.','W','B','B','W','W'},
                        {'B','B','B','.','.','W','B','.'}
                };
        int rMove = 0;
        int cMove = 4;

// (rMove, cMove)
        Character color = 'W';*/

        char[][] arr =
                {
                        {'W','B','W','.','.','W','W','.'},
                        {'W','B','.','W','W','W','B','W'},
                        {'.','B','B','.','B','W','B','W'},
                        {'.','.','B','B','B','W','W','.'},
                        {'B','B','.','B','.','.','.','B'},
                        {'.','W','B','.','.','B','.','B'},
                        {'.','W','.','W','.','W','B','W'},
                        {'W','.','B','.','W','W','B','.'}
                };
        int rMove = 4;
        int cMove = 6;

// (rMove, cMove)
        Character color = 'W';

        Solution1958 solution1958 = new Solution1958();
        boolean b = solution1958.checkMove(arr, rMove, cMove, color);
        System.out.println(b);
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        /*if (board[rMove][cMove] != '.') {
            return false;
        }*/
        //x y
        board[rMove][cMove] = color;
        char nextColor = color == 'B' ? 'W' : 'B';
        boolean b = checkX(rMove, cMove, color, nextColor, board);
        if (b) {
            return true;
        }
        b = checkY(rMove, cMove, color, nextColor, board);
        if (b) {
            return true;
        }
        b = checkXY(rMove, cMove, color, nextColor, board);
        return b;
    }

    private boolean checkXY(int rMove, int cMove, char color, char nextColor, char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        boolean flag = false;
        for (int i = rMove + 1, j = cMove + 1; i < xLen && j < yLen; i++, j++) {
            char v = board[i][j];
            if (v == '.') {
                flag = false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(i - rMove)) > 1) {
                    return true;
                }
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        for (int i = rMove - 1, j = cMove - 1; i >= 0 && j >= 0; i--, j--) {
            char v = board[i][j];
            if (v == '.') {
                flag = false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(i - rMove)) > 1) {
                    return true;
                }
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        for (int i = rMove - 1, j = cMove + 1; i >= 0 && j < yLen; i--, j++) {
            char v = board[i][j];
            if (v == '.') {
                flag = false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(i - rMove)) > 1) {
                    return true;
                }
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        for (int i = rMove + 1, j = cMove - 1; i < xLen && j >= 0; i++, j--) {
            char v = board[i][j];
            if (v == '.') {
                flag = false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(i - rMove)) > 1) {
                    return true;
                }
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkY(int rMove, int cMove, char color, char nextColor, char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        boolean flag=false;
        for (int i = rMove + 1; i < xLen; i++) {
            char v = board[i][cMove];
            if (v == '.') {
                flag=false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((i - rMove) > 1) {
                    return true;
                }
                flag=false;
                break;
            }
        }
        for (int i = rMove - 1; i >= 0; i--) {
            char v = board[i][cMove];
            if (v == '.') {
                flag=false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(rMove - i)) > 1) {
                    return true;
                }
                flag=false;
                break;
            }
        }
        return flag;
    }

    private boolean checkX(int rMove, int cMove, char color, char nextColor, char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        boolean flag=false;
        for (int i = cMove + 1; i < yLen; i++) {
            char v = board[rMove][i];
            if (v == '.') {
                flag=false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((i - cMove) > 1) {
                    return true;
                }
                flag=false;
                break;
            }
        }
        for (int i = cMove - 1; i >= 0; i--) {
            char v = board[rMove][i];
            if (v == '.') {
                flag=false;
                break;
            }
            if (v == nextColor) {
                continue;
            } else if (v == color) {
                if ((Math.abs(cMove - i)) > 1) {
                    return true;
                }
                flag=false;
                break;
            }
        }
        return flag;
    }
}
