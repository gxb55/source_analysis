package com.trip.algorithm.leet.l24.l09;

/**
 * @author xbguo
 * @date 2024/9/29 10:50
 */
public class Solution2073 {
    public static void main(String[] args) {
       /* int[] tickets = {2, 3, 2};
        int k = 2; */
        int[] tickets = {5,1,1,1};
        int k = 0;
        int i = timeRequiredToBuy(tickets, k);
        System.out.println(i);
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int index = 0;
        int count = 0;
        while (tickets[k] != 0) {
            int i = index % tickets.length;
            if (tickets[i] == 0) {

            } else {
                tickets[i]--;
                count++;
            }
            index++;

        }
        return count;
    }
}
