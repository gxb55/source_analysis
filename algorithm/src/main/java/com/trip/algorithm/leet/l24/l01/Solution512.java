package com.trip.algorithm.leet.l24.l01;

import java.util.*;

public class Solution512 {
    public static void main(String[] args) {
        Solution512 solution512 = new Solution512();
        //  String ring = "godding", key = "gd";
        // String ring = "godding", key = "godding";
        String ring = "abcde", key = "ade";
        int rotateSteps = solution512.findRotateSteps(ring, key);
        System.out.println(rotateSteps);
    }

    public int findRotateSteps(String ring, String key) {
        char[] ringCharArray = ring.toCharArray();
        char[] keyCharArray = key.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ringCharArray.length; i++) {
            char c = ringCharArray[i];
            List<Integer> orDefault = map.getOrDefault(c, new ArrayList<>());
            orDefault.add(i);
            map.put(c, orDefault);
        }
        this.ringCharArray = ringCharArray;
        this.keyCharArray = keyCharArray;
        this.map = map;
        int[][] dp = new int[key.length()][ring.length()];
        this.dp = dp;
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(0, 0);
    }

    private char[] ringCharArray;
    private char[] keyCharArray;
    private Map<Character, List<Integer>> map;
    private int[][] dp;

    private int dfs(int keIndex, int ringIndex) {
        if (keIndex >= keyCharArray.length) {
            return -1;
        }
        return 0;
    }

    private void process(int curIndex, int index, char[] charArray, Map<Character, List<Integer>> map, int len, String ring) {
        if (curIndex >= charArray.length) {
            if (max == -1) {
                max = len;
            } else {
                max = Math.min(max, len);
            }
            return;
        }
        char c = charArray[curIndex];
        List<Integer> integers = map.get(c);
        for (int i : integers) {
            int t = 0;
            if (i >= curIndex) {
                t = (i - curIndex) + 1;
            } else {
                t = (i + ring.length() - curIndex) + 1;
            }
            process(curIndex + 1, i, charArray, map, len + t, ring);

            if (i >= curIndex) {
                t = (curIndex + ring.length() - i) + 1;
            } else {
                t = (curIndex - i) + 1;
            }
            process(curIndex + 1, i, charArray, map, len + t, ring);
        }

    }

    int max = -1;
}
