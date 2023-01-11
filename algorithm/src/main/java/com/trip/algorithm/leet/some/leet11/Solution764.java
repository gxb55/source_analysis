package com.trip.algorithm.leet.some.leet11;

/**
 * @auther: xbguo
 * @date: 2022/11/9 09:30
 * @description: Solution764
 */
public class Solution764 {
    public static void main(String[] args) {
        Solution764 solution764 = new Solution764();
        int n = 5;
        int[][] mines = {{4, 2}, {1, 2}, {1, 2}, {1, 3}};

       /* int n = 1;
        int[][] mines = {{0, 0}};*/
        int i = solution764.orderOfLargestPlusSign2(n, mines);
        System.out.println(i);
    }

    public int orderOfLargestPlusSign2(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        for (int[] mine : mines) {
            arr[mine[0]][mine[1]] = 1;
        }
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = count;
            }
            count = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(count, dp[i][j]);
            }


        }
        for (int j = 0; j < arr.length; j++) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(count, dp[i][j]);
            }
            count = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(count, dp[i][j]);
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public int orderOfLargestPlusSign1(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        for (int[] mine : mines) {
            arr[mine[0]][mine[1]] = 1;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int i1 = check1(i, j, arr);
                max = Math.max(max, i1);
            }
        }
        return max;
    }

    private int check1(int i, int j, int[][] arr) {
        int index = 0;
        while (true) {
            if ((i + index) >= arr.length || (i - index) < 0 || (j + index) >= arr.length || (j - index) < 0) {
                break;
            }
            if (index == 0) {
                if (arr[i][j] != 0) {
                    break;
                }
                index++;
            } else {
                if (arr[i + index][j] == 0 && arr[i][j + index] == 0 && arr[i - index][j] == 0 && arr[i][j - index] == 0) {
                    index++;
                } else {
                    break;
                }
            }
        }
        return index;
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        for (int[] mine : mines) {
            arr[mine[0]][mine[1]] = 1;
        }
        boolean[][] dp = new boolean[n][n];

        // 右下左上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 0;
        int len = n / 2 + 1;
        int i = 0;
        int j = 0;
        int curLen = 1;
        int directionIndex = 0;
        while (curLen <= len) {
            dp[i][j] = true;
            if (check(i, j, curLen, arr)) {
                max = Math.max(curLen, max);
                i = 0 + curLen;
                j = 0 + curLen;
                curLen++;
            } else {
                if (curLen == len) {
                    break;
                }
                int x = i + directions[directionIndex % 4][0];
                int y = j + directions[directionIndex % 4][1];
                if (x < 0 || y < 0 || x >= n || y >= n || dp[x][y]) {
                    directionIndex = directionIndex + 1;
                }
                i = i + directions[directionIndex % 4][0];
                j = j + directions[directionIndex % 4][1];
            }
        }
        return max;
    }

    private boolean check(int i, int j, int curLen, int[][] arr) {
        int index = 0;
        while (curLen > 0) {
            if (arr[i][j] == 0 && index == 0) {
                curLen--;
                index++;
            } else {
                if ((i + index) >= arr.length || (i - index) < 0 || (j + index) >= arr.length || (j - index) < 0) {
                    return false;
                }
                if (arr[i + index][j] == 0 && arr[i][j + index] == 0 && arr[i - index][j] == 0 && arr[i][j - index] == 0) {
                    curLen--;
                    index++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
