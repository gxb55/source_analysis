package com.trip.algorithm.leet.some.Leet2308;

import java.text.MessageFormat;

/**
 * @author xbguo
 * @date 2023/8/3 16:55
 */
public class Solution822 {
    public static void main(String[] args) {
       /* int[] fronts = {1, 2, 4, 4, 7};
        int[] backs = {1, 3, 4, 1, 3}; */

       /* int[] fronts = {1};
        int[] backs = {1};
        Solution822 solution822 = new Solution822();
        int flipgame = solution822.flipgame(fronts, backs);
        System.out.println(flipgame);*/

        String formatKey="<font color=\"#222222\"><b>新客立减30元</b></font>";
        String tag = MessageFormat.format(formatKey, "tag");
        System.out.println(tag);
    }

    public int flipgame(int[] fronts, int[] backs) {
        int[][] arr = new int[fronts.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = fronts[i];
            arr[i][1] = backs[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if (x == y) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[j][0] != x || arr[j][1] != x) {

                    } else {
                        flag = false;
                    }
                }
            }
            if (flag) {
                res = Math.min(res, x);
            }

            flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[j][0] != y || arr[j][1] != y) {

                    } else {
                        flag = false;
                    }
                }
            }
            if (flag) {
                res = Math.min(res, y);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
