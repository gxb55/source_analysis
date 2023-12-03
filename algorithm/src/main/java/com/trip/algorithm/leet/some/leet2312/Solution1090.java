package com.trip.algorithm.leet.some.leet2312;

import java.util.*;

public class Solution1090 {
    public static void main(String[] args) {
       /* int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5; */

      /*  int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4; */

      /*  int[][] trips = {{7,5,6},{6,7,8},{10,1,6}};
        int capacity = 16;*/

        int[][] trips = {{9,3,4},{9,1,7},{4,2,4},{7,4,5}};
        int capacity = 23;
        Solution1090 solution1090 = new Solution1090();
        boolean b = solution1090.carPooling(trips, capacity);
        System.out.println(b);
    }

    /**
     * [numPassengersi, fromi, toi]
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        boolean b = Arrays.stream(trips).map(x -> x[0]).anyMatch(x -> x > capacity);
        if (b) {
            return false;
        }
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Queue<int[]> list = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int res = capacity;
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int count = trip[0];
            int from = trip[1];
            int to = trip[2];
            while (!list.isEmpty() && list.peek()[0] <= from) {
                int[] remove = list.poll();
                res += remove[1];
            }
            res -= count;
            if (res < 0) {
                return false;
            }
            list.add(new int[]{to, count});
        }
        return true;
    }
}
