package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/23 09:54
 * @description Solution2011
 */
public class Solution2011 {
    public static void main(String[] args) {
        Solution2011 solution2011 = new Solution2011();
        String[] operations = {"--X", "X++", "X++"};
        int i = solution2011.finalValueAfterOperations(operations);
        System.out.println(i);
    }

    public int finalValueAfterOperations(String[] operations) {

        int x = 0;
        for (String str : operations) {
            if (str.contains("++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}

