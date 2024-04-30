package com.trip.algorithm.leet.l24.l04;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/4/30 14:39
 */
public class Solution1329 {

    public static void main(String[] args) {

    }

    public int[][] diagonalSort(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            list.add(new int[]{i, 0});
        }
        for (int i = 1; i < y; i++) {
            list.add(new int[]{0, i});
        }
        List<Integer> tempList = new LinkedList<>();
        while (!list.isEmpty()) {
            tempList.clear();
            int[] poll = list.poll();
            int i = poll[0];
            int j = poll[1];
            while (i < x && j < y) {
                tempList.add(mat[i][j]);
                i++;
                j++;
            }
            tempList.sort((q1, q2) -> q1 - q2);
            i = poll[0];
            j = poll[1];
            int index = 0;
            while (i < x && j < y) {
                mat[i][j] = tempList.get(index);
                i++;
                j++;
                index++;
            }
        }
        return mat;
    }
}
