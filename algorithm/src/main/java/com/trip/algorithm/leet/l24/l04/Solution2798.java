package com.trip.algorithm.leet.l24.l04;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/4/30 14:37
 */
public class Solution2798 {

    public static void main(String[] args) {

    }
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
       return (int) Arrays.stream(hours).filter(x->x>=target).count();
    }
}
