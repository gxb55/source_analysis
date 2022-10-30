package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月17日 11:15:00
 * 竞赛
 */
public class Solution_competition_2399 {
    public static void main(String[] args) {
        Solution_competition_2399 solution = new Solution_competition_2399();
      /*  String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        */
        String s = "aa";
        int[] distance = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean b = solution.checkDistances(s, distance);
        System.out.println(b);
    }

    public boolean checkDistances(String s, int[] distance) {
        Integer[] arr = new Integer[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int index = aChar - 'a';
            if (arr[index] == null) {
                arr[index] = i;
            } else {
                int i1 = i - 1 - arr[index];
                if (distance[index] != i1) {
                    return false;
                }
            }
        }
        return true;
    }
}
