package com.trip.algorithm.leet.l24.l06;

/**
 * @author xbguo
 * @date 2024/6/3 16:52
 * @description TODO
 */
public class Solution1103 {
    public static void main(String[] args) {

    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int cur = 1;
        int index = 0;
        while (candies > 0) {
            if (candies > cur) {
                res[index % num_people] += cur;
                candies -= cur;
                cur++;
                index++;
            } else {
                res[index % num_people] += candies;
                candies = 0;
            }

        }
        return res;
    }
}
