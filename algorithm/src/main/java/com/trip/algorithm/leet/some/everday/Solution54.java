package com.trip.algorithm.leet.some.everday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年07月10日 21:33:00
 */
public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
       /* int[][] matrix = {
                {1, 2, 3,10},
                {4, 5, 6,11},
                {41, 52,61,15},
                {7, 8, 9,12}
        }; */

        //[1,2,3,4,8,12,11,10,9,5,6,7]
        /*int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };*/

       /* int[][] matrix =  {
                {2,5},
                {8,4},
                {0,-1}
        };*/
        /*int[][] matrix =  {
                {1,2},
                {3,4}
        };*/
        List<Integer> list = solution54.spiralOrder( null);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0;
        int xEnd = matrix.length;
        int y = 0;
        int yEnd = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (true) {
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;
            for (int i = y; i < yEnd; i++) {
                if(x==(xEnd)){
                    return list;
                }
                list.add(matrix[x][i]);
                flag = false;
            }
            if (!flag) {
                x++;
            }
            for (int i = x; i < xEnd; i++) {
                if(y==(yEnd)){
                    return list;
                }
                list.add(matrix[i][yEnd - 1]);
                flag1 = false;
            }
            if (!flag1) {
                yEnd--;
            }
            for (int i = yEnd - 1; i >= y; i--) {
                if(x==(xEnd)){
                    return list;
                }
                list.add(matrix[xEnd - 1][i]);
                flag2 = false;
            }
            if (!flag2) {
                xEnd--;
            }
            for (int i = xEnd - 1; i >= x; i--) {
                if(y==(yEnd)){
                    return list;
                }
                list.add(matrix[i][y]);
                flag3 = false;
            }
            if (!flag3) {
                y++;
            }
            if (flag || flag3 || flag2 || flag1) {
                break;
            }
        }
        return list;
    }
}
