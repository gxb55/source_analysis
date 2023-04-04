package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/4 19:11
 */
public class Solution1000 {
    public static void main(String[] args) {

    }

    public static int mergeStones(int[] stones, int k) {
        int length = stones.length;
        if (k > length) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        int sum = 0;
        while (list.size() > k) {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {

            }
        }
        if(list.size()!=1){
            return -1;
        }
        return sum;
    }
}
