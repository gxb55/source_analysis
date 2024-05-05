package com.trip.algorithm.leet.l24.l05;

public class Solution1491 {
    public static void main(String[] args) {
        int[] arr={4000,3000,1000,2000};
        double average = average(arr);
        System.out.println(average);
    }

    public static double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        double sum = 0;
        for (int t : salary) {
            max = Math.max(t, max);
            min = Math.min(t, min);
            sum += t;
        }
        sum -= max;
        sum -= min;
        double v = Double.valueOf(salary.length - 2);
        double v1 = sum / v;
        return v1;
    }
}
