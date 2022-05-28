package com.trip.algorithm.zuo.other.search;

/**
 * 查询数组中的岛
 */
public class SearchLand {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0, 1, 0, 1}
        };
        SearchLand searchLand = new SearchLand();
        Integer land = searchLand.land(arr);
        System.out.println(land);
    }

    public Integer land(int[][] arr) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //岛的入口
                if (arr[i][j] == 1) {
                    count++;
                    findland(arr, i, j);
                }
            }
        }
        return count;
    }

    private void findland(int[][] arr, int i, int j) {
        int x = arr.length;
        int y = arr[0].length;
        if (i >= 0 && i < x && j >= 0 && j < y && arr[i][j] == 1) {
            arr[i][j] = 2;
        } else {
            return;
        }
        findland(arr, i + 1, j);
        findland(arr, i - 1, j);
        findland(arr, i, j + 1);
        findland(arr, i, j - 1);
    }

}
