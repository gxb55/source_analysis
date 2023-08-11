package com.trip.algorithm.leet.some.Leet2308;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/8/11 16:30
 */
public class Solution1572 {
    public static void main(String[] args) {
        Solution1572 solution1572 = new Solution1572();
       /* int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};*/
        int[][] mat = {{5}};
        int i = solution1572.diagonalSum(mat);
        System.out.println(i);
    }

    public int diagonalSum(int[][] mat) {
        int x = 0;
        int y = 0;
        int sum = 0;
        Set<String> set = new HashSet<>();
        while (x < mat.length && y < mat[0].length) {
            set.add(x+"_"+y);
            sum += mat[x][y];
            x++;
            y++;

        }
        x=0;
        y--;
        while (x >= 0 && y >= 0) {
            if (!set.contains(x+"_"+y)) {
                sum += mat[x][y];
            }
            x++;
            y--;
        }
        return sum;
    }
}
