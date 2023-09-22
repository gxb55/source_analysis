package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/20 10:17
 */
public class Solution_lcp_06 {
    public static void main(String[] args) {

    }
    public int minCount(int[] coins) {
    int sum=0;
    for (int x:coins){
        sum+=(x+1)/2;
    }
    return sum;
    }
}
