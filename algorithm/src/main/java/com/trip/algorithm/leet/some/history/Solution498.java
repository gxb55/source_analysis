package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/6/15  13:40
 * @description 498. 对角线遍历
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * 通过次数77,934提交次数144,839
 */
public class Solution498 {
    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        // int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //  int[][] arr = {{1, 2}, {3, 4}};
        // int[][] arr = {{2}, {3}};
         int[][] arr = {{2,3}};
        //int[][] arr = {{2, 5}, {8, 4}, {0, -1}};
        int[] diagonalOrder = solution498.findDiagonalOrder(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;
        int[] arr = new int[x * y];
        int i = 0;
        int j = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (; i < x; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int k = i, t = j; k >= 0 && t < y; k--, t++) {
                tempList.add(mat[k][t]);
            }
            list.add(tempList);

        }
        i--;
        j++;
        for (; j < y; j++) {
            List<Integer> tempList = new ArrayList<>();
            for (int k = i, t = j; k >= 0 && t < y; k--, t++) {
                tempList.add(mat[k][t]);
            }
            list.add(tempList);
        }
        int index = 0;
        boolean flag = true;
        for (int k = 0; k < list.size(); k++) {
            if (flag) {
                for (int l = 0; l < list.get(k).size(); l++) {
                    arr[index++] = list.get(k).get(l);
                }
            } else {
                for (int l = list.get(k).size() - 1; l >= 0; l--) {
                    arr[index++] = list.get(k).get(l);
                }
            }
            flag = !flag;
        }
        return arr;
    }
}
