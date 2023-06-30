package com.trip.algorithm.leet.some.leet2306;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/27 15:12
 */
public class Solution2606 {
    public static void main(String[] args) {
        // String s = "adaa", chars = "d";int[] vals = {-1000};
       /* String s = "kqqqqqkkkq", chars = "kq";
        int[] vals = {-6, 6};*/

        String s = "zox", chars = "zoxr";
        int[] vals = {2,-5,-4,-5};


        int i = maximumCostSubstring(s, chars, vals);
        System.out.println(i);
    }

    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = chars.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(chars2[i], vals[i]);
        }
        int[] dp = new int[s.length()];
        dp[0] = map.getOrDefault(chars1[0], chars1[0] - 'a' + 1);
        int max =Math.max(0, dp[0]);
        for (int i = 1; i < dp.length; i++) {
            int cur = map.getOrDefault(chars1[i], chars1[i] - 'a' + 1);
            if ((dp[i - 1] + cur) >= cur) {
                dp[i] = dp[i - 1] + cur;
            } else {
                dp[i] = cur;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
