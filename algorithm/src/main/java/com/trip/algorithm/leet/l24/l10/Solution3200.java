package com.trip.algorithm.leet.l24.l10;

/**
 * @author xbguo
 * @date 2024/10/15 19:08
 */
public class Solution3200 {
    public static void main(String[] args) {

    }

    public int maxHeightOfTriangle(int red, int blue) {
        int max = getMax(red, blue);
        int max1 = getMax(blue, red);
        return Math.max(max1,max);
    }

    private int getMax(int red, int blue) {

        int count = 0;
        boolean flag = true;
        int curCount = 1;
        while (true) {
            if (flag) {
                if (red >= curCount) {
                    red -= curCount;
                } else {
                    break;
                }
            } else {
                if (blue >= curCount) {
                    blue -= curCount;
                } else {
                    break;
                }
            }
            curCount++;
            flag = !flag;
            count++;
        }
        return count;
    }
}
