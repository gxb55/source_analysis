package com.trip.algorithm.leet.l24.l100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
     //  int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
       int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int[] arr = {1, 2, -1, -2};
        List<Integer> list = new ArrayList<>();
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        // 从上到下
        int t = 0;
        int b = matrix.length - 1;
        // 从左到有
        int l = 0;
        int r = matrix[0].length - 1;
        while (list.size() < xLen * yLen) {
            for (int i = 0; i < arr.length; i++) {
                if(list.size() >= xLen * yLen){
                    break;
                }
                int v = arr[i];
                if (v == 1) {
                    for (int j = l; j <= r; j++) {
                        list.add(matrix[t][j]);
                    }
                    t++;
                } else if (v == 2) {
                    for (int j = t; j <= b; j++) {
                        list.add(matrix[j][r]);
                    }
                    r--;
                } else if (v == -1) {
                    for (int j = r; j >= l; j--) {
                        list.add(matrix[b][j]);
                    }
                    b--;
                } else if (v == -2) {
                    for (int j = b; j >= t; j--) {
                        list.add(matrix[j][l]);
                    }
                    l++;
                }
            }
        }
        return list;
    }
}
