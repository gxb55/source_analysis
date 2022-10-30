package com.trip.algorithm.leet.some.everday;

/**
 * @author xbguo
 * @createTime 2022年08月06日 17:36:00
 */
public class Solution2303 {
    public static void main(String[] args) {
        Solution2303 solution2303 = new Solution2303();
        int[][] arr = {{1, 0}, {4, 25}, {5, 50}};
        int income=2;
        double v = solution2303.calculateTax(arr,income);
        System.out.println(v);
    }

    public double calculateTax(int[][] brackets, int income) {
        double sum = 0;
        for (int i = 0; i < brackets.length; i++) {
            int x = brackets[i][0];
            int y = brackets[i][1];
            int last = 0;
            if (i > 0) {
                last = brackets[i - 1][0];
            }
            if (income > x) {
                sum = sum + ((x - last) * y) / 100.0;
            } else {
                sum = sum + ((income - last) * y) / 100.0;
                break;
            }
        }
        return sum;
    }
}
