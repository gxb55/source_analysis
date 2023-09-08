package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/8 14:45
 */
public class Solution2651 {
    public static void main(String[] args) {

    }
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int i = arrivalTime + delayedTime;
        return i%24;
    }
}
