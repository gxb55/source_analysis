package com.trip.algorithm.leet.l24.l06;

/**
 * @author xbguo
 * @date 2024/6/21 10:28
 */
public class SolutionLcp61 {
    public static void main(String[] args) {

    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length;
        int[] dp1 = new int[len - 1];
        int[] dp2 = new int[len - 1];
        int max = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            int a = temperatureA[i];
            int b = temperatureA[i - 1];
            if (a == b) {
                dp1[i - 1] = 0;
            } else if (a > b) {
                dp1[i - 1] = 1;
            } else {
                dp1[i - 1] = -1;
            }
        }
        for (int i = 1; i < temperatureA.length; i++) {
            int a = temperatureB[i];
            int b = temperatureB[i - 1];
            if (a == b) {
                dp2[i - 1] = 0;
            } else if (a > b) {
                dp2[i - 1] = 1;
            } else {
                dp2[i - 1] = -1;
            }
        }
        int count=0;
        for (int i = 0; i < dp1.length; i++) {
            if(dp1[i]==dp2[i]){
                count++;
            }else {
                count=0;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
