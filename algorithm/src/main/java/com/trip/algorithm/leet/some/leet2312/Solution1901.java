package com.trip.algorithm.leet.some.leet2312;

public class Solution1901 {
    public static void main(String[] args) {

    }

    public int[] findPeakGrid(int[][] mat) {
        int xLen = mat.length;
        int yLen = mat[0].length;
        int l = 0;
        int r = xLen - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int index = -1;
            int val = -1;
            for (int i = 0; i < mat[mid].length; i++) {
                if (mat[mid][i] > val) {
                    val = mat[mid][i];
                    index = i;
                }
            }
            if ((mid - 1) >= 0 && mat[mid - 1][index] > val) {
                r = mid - 1;
                continue;
            }
            if ((mid + 1) < xLen && mat[mid + 1][index] > val) {
                l = mid + 1;
                continue;
            }
            return new int[]{mid, index};
        }
        return null;
    }
}
