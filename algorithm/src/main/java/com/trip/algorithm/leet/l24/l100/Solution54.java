package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int[] arr = {1, 2, -1, -2};
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int index1 = 1;
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int x=0;
        int y=0;
        while (list.size() < xLen * yLen) {
            for (int k = 0; k < arr.length; k++) {
                int v = arr[i];
                if(v==1){
                }
            }
        }
        return null;
    }
}
