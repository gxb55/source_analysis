package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/30 15:37
 * @description TODO
 */
public class Solution2739 {

    public static void main(String[] args) {

    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        while (mainTank > 0) {
            if (mainTank >= 5&&additionalTank>0) {
                mainTank -= 5;
                additionalTank -= 1;
                mainTank += 1;
                count = count + 50;
            } else {
                count = count + mainTank * 10;
            }

        }
        return count;
    }

}
