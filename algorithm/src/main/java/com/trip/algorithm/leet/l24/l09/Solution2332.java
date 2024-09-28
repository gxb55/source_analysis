package com.trip.algorithm.leet.l24.l09;

import java.util.Arrays;

public class Solution2332 {
    public static void main(String[] args) {
       /* int[] buses = {10, 20}, passengers = {2, 17, 18, 19};
        int capacity = 2;  */

       /* int[] buses = {20, 30, 10}, passengers = {19, 13, 26, 4, 25, 11, 21};
        int capacity = 2;*/

        int[] buses = {6,8,18,17}, passengers = {6,8,17};
        int capacity = 1;
        int i = latestTimeCatchTheBus(buses, passengers, capacity);
        System.out.println(i);
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        int k = 0;
        int t = 0;
        for (; k < buses.length ; k++) {
            int bus = buses[k];
            t = capacity;
            while (i < passengers.length && passengers[i] <= bus && t >0) {
                t--;
                i++;

            }
        }
        i--;
        int lastCatchTime = t >0 ? buses[buses.length - 1] : passengers[i];
        while (i >= 0 && passengers[i] == lastCatchTime) {
            i--;
            lastCatchTime--;
        }

        return lastCatchTime;
    }

    public static int latestTimeCatchTheBus1(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int pos = 0;
        int space = 0;

        for (int arrive : buses) {
            space = capacity;
            while (space > 0 && pos < passengers.length && passengers[pos] <= arrive) {
                space--;
                pos++;
            }
        }

        pos--;
        int lastCatchTime = space > 0 ? buses[buses.length - 1] : passengers[pos];
        while (pos >= 0 && passengers[pos] == lastCatchTime) {
            pos--;
            lastCatchTime--;
        }

        return lastCatchTime;
    }

}
