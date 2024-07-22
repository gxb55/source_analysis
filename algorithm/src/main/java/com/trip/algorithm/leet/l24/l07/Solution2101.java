package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/22 14:24
 */
public class Solution2101 {

    public static void main(String[] args) {
      //  int[][] bombs = {{1,1,5},{10,10,5}};
        int[][] bombs = {{54,95,4},{99,46,3},{29,21,3},{96,72,8},{49,43,3},{11,20,3},{2,57,1},{69,51,7},{97,1,10},{85,45,2},{38,47,1},{83,75,3},{65,59,3},{33,4,1},{32,10,2},{20,97,8},{35,37,3}};
        int i = maximumDetonation(bombs);
        System.out.println(i);
    }

    public static int maximumDetonation(int[][] bombs) {
        int count = 1;
        for (int i = 0; i < bombs.length; i++) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int z = bombs[i][2];
            int t = 1;
            for (int j = 0; j < bombs.length; j++) {
                int x1 = bombs[j][0];
                int y1 = bombs[j][1];
                int z1 = bombs[j][2];
                if (i == j) {
                    continue;
                }
                long v = Math.abs(x - x1) * Math.abs(x - x1) + Math.abs(y - y1) * Math.abs(y - y1);
                long v1 = (z + z1) * (z + z1);
                if ( v1> v) {
                    t++;
                }
            }
            count = Math.max(count, t);
        }
        return count;
    }

}
