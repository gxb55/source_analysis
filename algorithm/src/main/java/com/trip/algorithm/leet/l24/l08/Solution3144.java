package com.trip.algorithm.leet.l24.l08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/8/28 14:09
 */
public class Solution3144 {
    public static void main(String[] args) {

    }



    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            Map<Character, Integer> occCnt = new HashMap<Character, Integer>();
            int maxCnt = 0;
            for (int j = i; j >= 1; j--) {
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
                if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }
    static final int INF = 0x3f3f3f3f;
}
