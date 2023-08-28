package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @createTime 2023年08月22日 22:00:00
 */
public class Solution605 {
    public static void main(String[] args) {

        //  int[] arr={1,0,0,0,0,1};
        // int t=2;
        int[] arr = {0};
        Solution605 solution605 = new Solution605();
        int t = 1;
        boolean b = solution605.canPlaceFlowers(arr, t);
        System.out.println(b);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int val = flowerbed[i];
            if (val == 1) {

            } else {
                if (i == 0) {
                    if ((i + 1)>=flowerbed.length||flowerbed[i + 1] == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return count >= n;
    }
}
