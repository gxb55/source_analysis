package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月20日 09:55:00
 */
public class Solution799 {
    public static void main(String[] args) {
        Solution799 solution799 = new Solution799();
        //poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
        // int poured = 1, query_glass = 1, query_row = 1;
         int poured = 2, query_glass = 1, query_row = 1;
      //  int poured = 100000009, query_row = 33, query_glass = 17;
        //int poured = 25, query_row = 6, query_glass = 1;
        double v = solution799.champagneTower3(poured, query_row, query_glass);
        System.out.println(v);
        System.out.println("=================");
        double v1 = solution799.champagneTower1(poured, query_row, query_glass);
        System.out.println(v1);
    }


    public double champagneTower3(int poured, int query_row, int query_glass) {
        double[][] arr = new double[query_row+1][query_row+1];
        arr[0][0]=poured;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j <= i; j++) {
                double v = arr[i][j];
                if(v>1){
                    double v1 = (v - 1) / 2;
                    arr[i+1][j]=v1+arr[i+1][j];
                    arr[i+1][j+1]=v1+arr[i+1][j+1];
                }
            }
        }
        return Math.min(1,arr[query_row][query_glass]);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        int cur = 0;
        int last = 0;
        for (int i = 0; i <= query_row; i++) {
            if (i <= query_row - 1) {
                last = last + i + 1;
            }
            cur = cur + i + 1;
        }
        if (poured >= cur) {
            return 1;
        } else if (poured <= last) {
            return 0;
        }
        double res = poured - last;
        double i = res / Double.valueOf(((query_row + 1) - 2) * 2 + 2);
        if (query_glass == 0 || query_glass == query_row) {
            return i;
        }
        return 2 * i;
    }
    public double champagneTower1(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
