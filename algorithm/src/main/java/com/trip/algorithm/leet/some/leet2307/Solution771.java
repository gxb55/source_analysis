package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @date 2023/7/24 10:36
 */
public class Solution771 {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String jewels, String stones) {
        char[] chars = stones.toCharArray();
        int res = 0;
        for (Character character : chars) {
            if (jewels.contains(String.valueOf(character))) {
                res++;
            }
        }
        return res;
    }
}
