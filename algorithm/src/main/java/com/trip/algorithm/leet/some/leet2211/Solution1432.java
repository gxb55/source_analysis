package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月19日 11:13:00
 */
public class Solution1432 {
    public static void main(String[] args) {
        Solution1432 solution1432 = new Solution1432();
        int[] arr={-5,1,5,0,-7};
        int i = solution1432.largestAltitude(arr);
        System.out.println(i);
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int last = 0;
        for (int x : gain) {
            last = last + x;
            max = Math.max(max, last);
        }
        return max;
    }
}
