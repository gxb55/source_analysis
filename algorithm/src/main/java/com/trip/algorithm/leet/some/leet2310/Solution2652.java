package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/17 09:43
 */
public class Solution2652 {
    public static void main(String[] args) {
        int k = 7;
        int i = sumOfMultiples(k);
        System.out.println(i);
    }

    public static int sumOfMultiples(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0|| i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return (int) sum;
    }
}
