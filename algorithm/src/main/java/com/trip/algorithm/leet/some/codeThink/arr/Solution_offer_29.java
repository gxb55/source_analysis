package com.trip.algorithm.leet.some.codeThink.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年11月01日 22:17:00
 */
public class Solution_offer_29 {
    public static void main(String[] args) {
        Solution_offer_29 solution = new Solution_offer_29();
        /*int[][] arr = {{1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}};*/
        int[][] arr = {{1},
                {2}};
        int[] ints = solution.spiralOrder(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] spiralOrder(int[][] matrix) {
        int xLen = matrix.length;
        if (xLen == 0) {
            return new int[]{};
        }
        int yLen = matrix[0].length;
        int len = xLen * yLen;
        int[] res = new int[len];
        int[][] directionArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int i = 0;
        int j = 0;
        int directionIndex = 0;
        Set<String> strings = new HashSet<>();
        while (index < len) {
            res[index] = matrix[i][j];
            strings.add(i + ":" + j);
            int curI = i + directionArr[directionIndex][0];
            int curJ = j + directionArr[directionIndex][1];
            if (curI < 0 || curJ < 0 || curI >= xLen || curJ >= yLen || strings.contains(curI + ":" + curJ)) {
                directionIndex = (directionIndex + 1) % 4;
            }
            i = i + directionArr[directionIndex][0];
            j = j + directionArr[directionIndex][1];
            index++;
        }
        return res;
    }
}
