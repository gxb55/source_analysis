package com.trip.algorithm.leet.some;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author xbguo
 * @createTime 2022年04月04日 15:14:00
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 * 通过次数263,834提交次数415,497
 * 请问您在哪类招聘中遇到此题？
 */
public class Leet_36 {
    public static void main(String[] args) {
        Leet_36 leet_36 = new Leet_36();
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = leet_36.isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        Set<Character> set = new TreeSet<>();
        Set<Character> set1 = new TreeSet<>();

        Set<Character> set2 = new TreeSet<>();
        Set<Character> set3 = new TreeSet<>();
        Set<Character> set4 = new TreeSet<>();

        Set<Character> set5 = new TreeSet<>();
        Set<Character> set6 = new TreeSet<>();
        Set<Character> set7 = new TreeSet<>();

        Set<Character> set8 = new TreeSet<>();
        Set<Character> set9 = new TreeSet<>();
        Set<Character> set10 = new TreeSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char c = board[i][j];
                char c1 = board[j][i];

                if (!set.add(c) && c != '.') {
                    return false;
                }
                if (!set1.add(c1) && c1 != '.') {
                    return false;
                }
                if (board[i][j] != '.') {

                    if (i / 3 == 0 && j / 3 == 0) {
                        if (!set2.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 1 && j / 3 == 1) {
                        if (!set3.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 2 && j / 3 == 2) {
                        if (!set4.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 0 && j / 3 == 1) {
                        if (!set5.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 0 && j / 3 == 2) {
                        if (!set6.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 1 && j / 3 == 0) {
                        if (!set7.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 1 && j / 3 == 2) {
                        if (!set8.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 2 && j / 3 == 0) {
                        if (!set9.add(board[i][j])) {
                            return false;
                        }
                    }

                    if (i / 3 == 2 && j / 3 == 1) {
                        if (!set10.add(board[i][j])) {
                            return false;
                        }
                    }
                }

            }
            set.clear();
            set1.clear();
        }


        return true;
    }
}
