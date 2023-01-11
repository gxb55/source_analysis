package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月09日 08:16:00
 */
public class Solution764 {
    public static void main(String[] args) {
        Solution764 solution764 = new Solution764();

    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] arr = new int[n][n];
        for (int[] mine : mines) {
            arr[mine[0]][mine[1]] = 1;
        }
        // 右下左上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 0;
        int len = n / 2 + 1;
        int i = 0;
        int j = 0;
        int curLen = 1;
        int directionIndex = 0;
        while (curLen <= len) {
            if (check(i, j, curLen, arr)) {
                max = Math.max(curLen, max);
                i = 0 + curLen;
                j = 0 + curLen;
                curLen++;
            } else {
                int x = i + directions[directionIndex % 4][0];
                int y = j + directions[directionIndex % 4][1];
                if (x < 0 || y < 0 || x >= n || y >= n) {
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
        while (curLen >= 0) {
            if (arr[i][j] == 0 && index == 0) {
                curLen--;
                index++;
            } else {
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
