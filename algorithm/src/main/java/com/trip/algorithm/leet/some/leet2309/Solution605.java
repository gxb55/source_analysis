package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/29 18:29
 */
public class Solution605 {
    public static void main(String[] args) {
        Solution605 solution605 = new Solution605();
        int[] flowerbed = {0};
        int n = 1;
        boolean b = solution605.canPlaceFlowers(flowerbed, n);
        System.out.println(b);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int val = flowerbed[i];
            if (val == 1) {

            } else {
                if (i == 0) {
                    if (i + 1 >= flowerbed.length) {
                        flowerbed[i] = 1;
                        count++;
                    } else if ((i + 1) < flowerbed.length && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if (i == flowerbed.length - 1 && (i - 1) >= 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                } else if ((i - 1) >= 0 && (i + 1) < flowerbed.length) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return count >= n;
    }
}

